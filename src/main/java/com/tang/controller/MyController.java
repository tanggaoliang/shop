/**
 * @author: tang gao liang
 * @time:2019/4/23 21:38:25
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.controller;

import com.tang.mapper.ProductMapper;
import com.tang.pojo.Info;
import com.tang.pojo.OrderItem;
import com.tang.pojo.Product;
import com.tang.pojo.User;
import com.tang.service.InfoService;
import com.tang.service.OrderItemService;
import com.tang.service.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {
    @Autowired
    UserService userService;
    @Autowired
    private ProductMapper productService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private InfoService infoService;

    @RequestMapping(value = "/showCategory/{cid}")
    public ModelAndView showCategory(@PathVariable("cid") int cid) {
        ModelAndView mav = new ModelAndView("search");
        List<Product> products = productService.listByCid(cid);
        mav.addObject("products", products);
        return mav;
    }

    @RequestMapping(value = "/detail/{id}")
    public ModelAndView productDetail(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("detail");
        Product product = productService.get(id);
        mav.addObject("product", product);
        return mav;
    }

    @RequestMapping(value = "/search")
    public ModelAndView showCategory(@RequestParam("name") String name) {
        List<Product> products = productService.listByName(name);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("products", products);
        return mav;
    }

    @RequestMapping(value = "/cart")
    public ModelAndView showCart(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<OrderItem> orderItems = orderItemService.listByCartByUid(user.getId());
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getNum() * orderItem.getProduct().getPrice();
        }
        ModelAndView mav = new ModelAndView("cart");
        mav.addObject("orderItems", orderItems);
        mav.addObject("totalPrice", totalPrice);
        return mav;
    }

    @RequestMapping(value = "/addProductToCart")
    public void addProductToCart(@RequestParam("pid") int pid, @RequestParam("num") int num, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int uid = user.getId();
        Integer orderItemId = orderItemService.ifInCart(uid, pid);
        if (null == orderItemId) {
            OrderItem orderItem = new OrderItem();
            orderItem.setNum(num);
            orderItem.setUser(user);
            orderItem.setProduct(productService.get(pid));
            orderItem.setSuccess(0);
            orderItemService.add(orderItem);
        } else {
            OrderItem orderItem1 = orderItemService.get(orderItemId);
            orderItem1.setNum(orderItem1.getNum() + num);
            orderItemService.update(orderItem1);
        }
    }

    @RequestMapping(value = "/deleteOrderItem/{pid}")
    public ModelAndView deleteOrderItem(@PathVariable("pid") int pid) {
        orderItemService.delete(pid);
        return new ModelAndView("redirect:/cart");
    }

    @RequestMapping(value = "/updateOrderItem")
    @ResponseBody
    public Map<String, String> updateOrderitem(@RequestParam("id") int id, @RequestParam("num") int num, HttpSession session) {
        OrderItem orderItem = orderItemService.get(id);
        orderItem.setNum(num);
        orderItemService.update(orderItem);
        User user = (User) session.getAttribute("user");
        List<OrderItem> orderItems = orderItemService.listByCartByUid(user.getId());
        int totalPrice = 0;
        for (OrderItem orderItem1 : orderItems) {
            totalPrice += orderItem1.getNum() * orderItem1.getProduct().getPrice();
        }
        Map map = new HashMap(1);
        map.put("totalPrice", "合计:￥" + totalPrice);
        return map;
    }

    @RequestMapping("/changePasswordAction")
    public ModelAndView changePasswordAction(@RequestParam("password1") String password1, @RequestParam("password2") String password2, HttpSession session) {
        if (password1.equals(password2)) {
            User user = (User) session.getAttribute("user");
            String salt = new SecureRandomNumberGenerator().nextBytes().toString();
            int times = 2;
            String algorithmName = "md5";
            String encodedPassword = new SimpleHash(algorithmName, password1, salt, times).toString();
            user.setPassword(encodedPassword);
            user.setSalt(salt);
            userService.update(user);
            return new ModelAndView("redirect:/");
        } else {
            ModelAndView modelAndView = new ModelAndView("changePassword");
            modelAndView.addObject("errorInfo", "两次密码不一致,请重新输入!");
            return modelAndView;
        }

    }

    @RequestMapping("/createOrder")
    public String createOrder(HttpSession session) {
        User user = (User) session.getAttribute("user");
        int uid = user.getId();
        orderItemService.createOrder(uid);
        return "success";
    }

    @RequestMapping("/createSingleOrder")
    public String createSingleOrder(HttpSession session, @RequestParam("productId") int productId, @RequestParam("productNumberInput") int productNumberInput) {
        User user = (User) session.getAttribute("user");
        OrderItem orderItem = new OrderItem();
        orderItem.setUser(user);
        orderItem.setProduct(productService.get(productId));
        orderItem.setNum(productNumberInput);
        orderItem.setSuccess(1);
        orderItemService.add(orderItem);
        return "success";

    }

    @RequestMapping("/order")
    public ModelAndView order(HttpSession session) {
        User user = (User) session.getAttribute("user");
        int uid = user.getId();
        List<OrderItem> orderItems = orderItemService.listByOrder(uid);
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("orderItems", orderItems);
        return modelAndView;
    }

    @RequestMapping("/addInfoAction")
    public String addInfo(@RequestParam("userName") String userName, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("province") String province, @RequestParam("city") String city, @RequestParam("county") String county, @RequestParam("address") String address,

                        HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int uid = user.getId();
        Info info = new Info();
        info.setUid(uid);
        info.setName(userName);
        info.setPhoneNumber(phoneNumber);
        info.setAddress(province + city + county + address);
        if (request.getParameter("checkbox") != null) {
            infoService.defaultAddress(uid);
            info.setSelected(1);
        } else {
            info.setSelected(0);
        }
        infoService.add(info);
        return "redirect:/info";
    }

    @RequestMapping("/info")
    public ModelAndView info(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Info> infoList = infoService.list(user.getId());
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("infoList", infoList);
        return modelAndView;
    }

    @RequestMapping("/deleteInfo/{id}")
    public ModelAndView deleteInfo(@PathVariable("id") int id) {
        infoService.delete(id);
        return new ModelAndView("redirect:/info");
    }

    @RequestMapping("/editInfo/{id}")
    public ModelAndView editInfo(HttpSession session, @PathVariable("id") int id) {
        Info info = infoService.get(id);
        ModelAndView modelAndView = new ModelAndView("updateInfo");
        modelAndView.addObject("info", info);
        return modelAndView;
    }

    @RequestMapping("/updateInfoAction")
    public ModelAndView updateInfo(@RequestParam("id") int id, @RequestParam("userName") String userName, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("address") String address,
                                   HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int uid = user.getId();
        Info info = new Info();
        info.setId(id);
        info.setUid(uid);
        info.setName(userName);
        info.setPhoneNumber(phoneNumber);
        info.setAddress(address);
        if (request.getParameter("checkbox") != null) {
            infoService.defaultAddress(uid);
            info.setSelected(1);
        } else {
            info.setSelected(0);
        }
        infoService.update(info);
        return new ModelAndView("redirect:/info");
    }

}
