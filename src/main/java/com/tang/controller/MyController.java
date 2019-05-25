/**
 * @author: tang gao liang
 * @time:2019/4/23 21:38:25
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.controller;

import com.tang.mapper.ProductMapper;
import com.tang.pojo.*;
import com.tang.service.*;
import com.tang.util.Page;
import org.apache.commons.lang.RandomStringUtils;
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
import java.io.File;
import java.io.IOException;
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
    private CategoryService categoryService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private InfoService infoService;
    @Autowired
    private EvaluateService evaluateService;
    @Autowired
    private GroupBuyService groupBuyService;

    @RequestMapping(value = "/showCategory/{cid}")
    public ModelAndView showCategory(@PathVariable("cid") int cid, @RequestParam(value = "start", required = false) Integer start, HttpSession session) {
        ModelAndView mav = new ModelAndView("search");
        Page page = new Page();
        int total = productService.countByCid(cid);
        page.calculateLast(total);
        page.setPageCount(calc(total, page.getCount()));
        page.setStart(start);
        page.setCid(cid);
        List<Product> products = productService.listByCidByCount(page);
        session.setAttribute("page", page);
        mav.addObject("products", products);
        return mav;
    }

    @RequestMapping(value = "/manageEditProduct/{id}")
    public ModelAndView manageEditProduct(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("manageEditProduct");
        Product product = productService.get(id);
        mav.addObject("product", product);
        return mav;
    }

    @RequestMapping(value = "/detail/{id}")
    public ModelAndView productDetail(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("detail");
        Product product = productService.get(id);
        List<Evaluate> evaluateList = evaluateService.list(id);
        GroupBuy groupBuy = groupBuyService.inGroup(id);
        Integer groupNum = 0;
        if (groupBuy != null) {
            groupNum = groupBuy.getUserNum();
        }
        mav.addObject("product", product);
        mav.addObject("evaluateList", evaluateList);
        mav.addObject("groupNum", groupNum);
        return mav;
    }


    @RequestMapping(value = "/search")
    public ModelAndView search(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "start", required = false) Integer start, HttpSession session) {
        if (null == name) {
            name = (String) session.getAttribute("searchName");
        } else {
            session.setAttribute("searchName", name);
        }
        Page page = new Page();
        int total = productService.listByName(name).size();
        page.setName(name);
        page.setTotal(total);
        page.calculateLast(total);
        page.setPageCount(calc(total, page.getCount()));
        page.setStart(start);
        List<Product> products = productService.listByNameByPage(page);
        User user = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        if (user.getRid() == 1) {
            modelAndView.setViewName("search");
        } else {
            modelAndView.setViewName("manageProduct");
        }
        session.setAttribute("page", page);
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    private int calc(int total, int count) {
        int result = total / count + 1;
        if (total % count == 0) {
            result--;
        }
        return result;
    }


    @RequestMapping(value = "/cart")
    public ModelAndView showCart(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<OrderItem> orderItems = orderItemService.listByCartByUid(user.getId());
        int totalPrice = getTotalPrice(orderItems);
        session.setAttribute("totalPrice_pay", totalPrice);
        ModelAndView mav = new ModelAndView("cart");
        mav.addObject("orderItems", orderItems);
        mav.addObject("totalPrice", totalPrice);
        return mav;
    }

    private int getTotalPrice(List<OrderItem> orderItems) {
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getNum() * orderItem.getLastPrice();
        }
        return totalPrice;
    }

    @RequestMapping(value = "/addProductToCart")
    @ResponseBody
    public Map<String, String> addProductToCart(@RequestParam("pid") int pid, @RequestParam("num") int num, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int uid = user.getId();
        myOrderItem(pid, num, uid);
        Map map = new HashMap(1);
        map.put("info", "加入购物车成功");
        return map;
    }

    /**
     * @param pid
     * @param num
     * @param uid
     */
    private void myOrderItem(int pid, int num, int uid) {
        Integer orderItemId = orderItemService.ifInCart(uid, pid);
        if (null == orderItemId) {
            OrderItem orderItem = new OrderItem();
            orderItem.setNum(num);
            orderItem.setUser(userService.get(uid));
            orderItem.setProduct(productService.get(pid));
            orderItem.setLastPrice(productService.get(pid).getPrice());
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
        int totalPrice = getTotalPrice(orderItems);
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
        orderItem.setLastPrice(productService.get(productId).getPrice());
        orderItem.setNum(productNumberInput);
        orderItem.setSuccess(1);
        orderItemService.add(orderItem);
        session.setAttribute("totalPrice_pay", orderItem.getLastPrice() * orderItem.getNum());
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
        int id = user.getId();
        Info info = getInfo(id, userName, phoneNumber, province + city + county + address, request, session);
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
        Info info = getInfo(id, userName, phoneNumber, address, request, session);
        infoService.update(info);
        return new ModelAndView("redirect:/info");
    }

    private Info getInfo(@RequestParam("id") int id, @RequestParam("userName") String userName, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("address") String address, HttpServletRequest request, HttpSession session) {
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
        return info;
    }

    @RequestMapping("/manageProduct")
    public ModelAndView manageProduct(@RequestParam(value = "cid", required = false) Integer cid, @RequestParam(value = "start", required = false) Integer start, HttpSession session) {
        if (null == cid) {
            cid = (Integer) session.getAttribute("cid");
        } else {
            session.setAttribute("cid", cid);
        }
        Page page = new Page();
        int total = productService.countByCid(cid);
        page.calculateLast(total);
        page.setStart(start);
        page.setPageNum(page.getStart() / page.getCount());
        page.setPageCount(calc(total, page.getCount()));
        page.setCid(cid);
        List<Product> products = productService.listByCidByCount(page);
        ModelAndView modelAndView = new ModelAndView("manageProduct");
        session.setAttribute("page", page);
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @RequestMapping("/manageUser/{rid}")
    public ModelAndView manageUser(@PathVariable("rid") int rid, HttpSession session) {
        List<User> users = userService.list(rid);
        ModelAndView modelAndView = new ModelAndView("manageUser");
        modelAndView.addObject("users", users);
        String head = "";
        if (rid == 1) {
            head = "普通用户管理";
        } else {
            head = "管理员用户管理";
        }
        modelAndView.addObject("head", head);
        session.setAttribute("rid", rid);
        return modelAndView;
    }

    @RequestMapping("/uploadImage")
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile file, @RequestParam("pid") int pid) throws IllegalStateException, IOException {
        String name = RandomStringUtils.randomAlphanumeric(10);
        String newFileName = name + ".png";
        File newFile = new File(request.getServletContext().getRealPath("/uploadImage"), newFileName);
        newFile.getParentFile().mkdirs();
        file.getImage().transferTo(newFile);
        Product product = productService.get(pid);
        product.setFileName("/uploadImage/" + newFileName);
        productService.update(product);
        ModelAndView mav = new ModelAndView("redirect:/manageEditProduct/" + pid);
        return mav;
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(Product product, HttpSession session) {
        productService.update(product);
        int cid = (int) session.getAttribute("cid");
        return "redirect:/manageProduct?cid=" + cid;

    }

    @RequestMapping("/addProductAction")
    public String addProductAction(Product product, HttpSession session) {
        int cid = (int) session.getAttribute("cid");
        product.setCategory(categoryService.get(cid));
        productService.add(product);
        return "redirect:/manageProduct?cid=" + cid;
    }

    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id, HttpSession session) {
        productService.delete(id);
        int cid = (int) session.getAttribute("cid");
        return "redirect:/manageProduct?cid=" + cid;
    }

    @RequestMapping("/addProduct")
    public ModelAndView addProduct() {
        ModelAndView modelAndView = new ModelAndView("manageAddProduct");
        int id = productService.biGIndex();
        productService.insertOnlyId(id + 1);
        Product product = productService.get(id + 1);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping("/evaluate/{pid}")
    public ModelAndView evaluate(@PathVariable("pid") int pid) {
        Product product = productService.get(pid);
        ModelAndView modelAndView = new ModelAndView("evaluate");
        modelAndView.addObject(product);
        return modelAndView;
    }

    @RequestMapping("/evaluateAction")
    public String evaluateAction(Evaluate evaluate, int pid, int uid) {
        evaluate.setProduct(productService.get(pid));
        evaluate.setUser(userService.get(uid));
        evaluateService.add(evaluate);
        return "redirect:/order";
    }

    @RequestMapping("/orderItemService/{id}")
    public String orderItemService(@PathVariable("id") int id) {
        orderItemService.delete(id);
        return "redirect:/order";
    }

    @RequestMapping("/orderItemService2/{id}")
    public String orderItemService2(@PathVariable("id") int id) {
        orderItemService.delete(id);
        return "redirect:/manageOrderItem";
    }

    @RequestMapping("/manageOrderItem")
    public ModelAndView manageOrderItem() {
        ModelAndView modelAndView = new ModelAndView("manageOrderItem");
        List<OrderItem> orderItemList1 = orderItemService.listAllOrder();
        modelAndView.addObject("orderItemList1", orderItemList1);
        return modelAndView;
    }

    @RequestMapping("/manageEvaluate")
    public ModelAndView manageEvaluate() {
        ModelAndView modelAndView = new ModelAndView("manageEvaluate");
        List<Evaluate> evaluateList = evaluateService.listAll();
        modelAndView.addObject("evaluateList", evaluateList);
        return modelAndView;
    }

    @RequestMapping("/deleteEvaluate/{id}")
    public String deleteEvaluate(@PathVariable("id") int id) {
        evaluateService.delete(id);
        return "redirect:/manageEvaluate";
    }

    @RequestMapping("/groupBuy")
    @ResponseBody
    public Map groupBuy(int pid, int uid, int num) {

        GroupBuy groupBuy = groupBuyService.inGroup(pid);
        Integer userNum = 0;
        if (groupBuy != null) {
            if (null != groupBuy.getUid1()) {
                if (groupBuy.getUid1() == uid) {
                    return null;
                }
            }
            if (null != groupBuy.getUid2()) {
                if (groupBuy.getUid2() == uid) {
                    return null;
                }
            }

        }
        if (groupBuy == null) {
            groupBuy = new GroupBuy();
            groupBuy.setUid1(uid);
            groupBuy.setPid(pid);
            groupBuy.setNum1(num);
            groupBuy.setUserNum(1);
            groupBuyService.add(groupBuy);
            userNum = 1;
        } else if (groupBuy.getUserNum() == 1) {
            groupBuy.setUid2(uid);
            groupBuy.setNum2(num);
            groupBuy.setUserNum(2);
            groupBuyService.update(groupBuy);
            userNum = 2;
        } else {
            Product product = productService.get(pid);
            groupBuy.setUid3(uid);
            groupBuy.setNum3(num);
            groupBuy.setUserNum(3);
            groupBuyService.update(groupBuy);
            OrderItem orderItem1 = new OrderItem();
            OrderItem orderItem2 = new OrderItem();
            OrderItem orderItem3 = new OrderItem();
            orderItem1.setUser(userService.get(groupBuy.getUid1()));
            orderItem2.setUser(userService.get(groupBuy.getUid2()));
            orderItem3.setUser(userService.get(groupBuy.getUid3()));
            orderItem1.setProduct(product);
            orderItem2.setProduct(product);
            orderItem3.setProduct(product);
            orderItem1.setNum(groupBuy.getNum1());
            orderItem2.setNum(groupBuy.getNum2());
            orderItem3.setNum(groupBuy.getNum3());
            orderItem1.setLastPrice(product.getPrice2());
            orderItem2.setLastPrice(product.getPrice2());
            orderItem3.setLastPrice(product.getPrice2());

            tangInsertOrderItem(orderItem1);
            tangInsertOrderItem(orderItem2);
            tangInsertOrderItem(orderItem3);

            groupBuyService.delete(groupBuy.getId());
        }
        Map map = new HashMap(1);
        map.put("userNum", userNum);
        return map;
    }

    private void tangInsertOrderItem(OrderItem orderItem) {
        Integer orderItemId = orderItemService.ifInCart(orderItem.getUser().getId(), orderItem.getProduct().getId());
        if (null == orderItemId) {
            orderItemService.add(orderItem);
        } else {
            OrderItem orderItem1 = orderItemService.get(orderItemId);
            orderItem1.setNum(orderItem1.getNum() + orderItem.getNum());
            orderItem1.setLastPrice(orderItem1.getProduct().getPrice2());
            orderItemService.update(orderItem1);
        }
    }

    @RequestMapping("/home")
    public String home(@RequestParam(value = "start", required = false) Integer start, HttpSession session) {
        Page page = (Page) session.getAttribute("page");
        page.setCid(1);
        page.setStart(start);
        List<Product> products = productService.listByCidByCount(page);
        page.setTotal(products.size());
        session.setAttribute("page", page);
        session.setAttribute("products", products);
        return "home";
    }


}
