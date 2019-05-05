package com.tang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tang.pojo.Product;
import com.tang.pojo.User;
import com.tang.service.ProductService;
import com.tang.service.UserService;
import com.tang.util.Page;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @RequestMapping("listUser")
    public ModelAndView listUser(Page page) {
        ModelAndView mav = new ModelAndView("listUser");
        PageHelper.offsetPage(page.getStart(), 5);
        List<User> cs = userService.list();
        int total = (int) new PageInfo<>(cs).getTotal();
        page.calculateLast(total);

        // 放入转发参数
        mav.addObject("cs", cs);
        System.out.println(mav);
        // 放入jsp路径

        return mav;
    }

    @RequestMapping("addUser")
    public ModelAndView addUser(@RequestParam("userName") String userName, @RequestParam("password1") String password1, @RequestParam("password2") String password2) {
        String errInfo;
        userName = userName.trim();
        if (null != userService.getByUserName(userName)) {
            errInfo = "用户名已存在";
            ModelAndView mav = new ModelAndView("/register");
            mav.addObject("errorInfo", errInfo);
            return mav;
        } else if (!password1.equals(password2)) {
            errInfo = "两次密码不一致";
            ModelAndView mav = new ModelAndView("/register");
            mav.addObject("errorInfo", errInfo);
            return mav;
        } else {
            String salt = new SecureRandomNumberGenerator().nextBytes().toString();
            int times = 2;
            String algorithmName = "md5";
            String encodedPassword = new SimpleHash(algorithmName, password1, salt, times).toString();
            User user = new User();
            user.setUserName(userName);
            user.setPassword(encodedPassword);
            user.setSalt(salt);
            userService.add(user);
            ModelAndView mav = new ModelAndView("redirect:/");
            return mav;
        }
    }

    @RequestMapping("deleteUser")
    public ModelAndView deleteUser(User user) {
        userService.delete(user);
        ModelAndView mav = new ModelAndView("redirect:/listUser");
        return mav;
    }

    @RequestMapping("editUser")
    public ModelAndView editUser(User user) {
        User c = userService.get(user.getId());
        ModelAndView mav = new ModelAndView("editUser");
        mav.addObject("c", c);
        return mav;
    }

    @RequestMapping("updateUser")
    public ModelAndView updateUser(User user) {
        userService.update(user);
        ModelAndView mav = new ModelAndView("redirect:/listUser");
        return mav;
    }

    @RequestMapping("loginAction")
    public ModelAndView loginAction(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpSession session) {
        User user = userService.getByUserName(userName);
        if (null != user) {
            String passwordInDB = user.getPassword();
            String salt = user.getSalt();
            String passwordEncoded = new SimpleHash("md5", password, salt, 2).toString();
            if (passwordEncoded.equals(passwordInDB)) {
                session.setAttribute("user", user);

                List<Product> products = productService.listByCid(1);
                for (Product product : products) {
                    System.out.println(product);
                }
                session.setAttribute("products",products);
                ModelAndView modelAndView = new ModelAndView("redirect:/home");
                return modelAndView;
            }
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        modelAndView.addObject("errorInfo", "登录失败,用户名或密码错误");
        return modelAndView;
    }


}