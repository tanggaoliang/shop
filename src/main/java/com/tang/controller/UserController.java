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
import org.springframework.web.bind.annotation.PathVariable;
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


    @RequestMapping("addUser")
    public ModelAndView addUser(@RequestParam("userName") String userName, @RequestParam("password1") String password1, @RequestParam("password2") String password2) {
        //是否返回注册
        String errInfo = getErrorInfo(userName, password1, password2);
        if (errInfo != "") {
            ModelAndView mav = new ModelAndView("/register");
            mav.addObject("errorInfo", errInfo);
            return mav;
        }
        User user = getUser(userName, password1);
        userService.add(user);
        ModelAndView mav = new ModelAndView("redirect:/");
        return mav;
    }

    private User getUser(@RequestParam("userName") String userName, @RequestParam("password1") String password1) {
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";
        String encodedPassword = new SimpleHash(algorithmName, password1, salt, times).toString();
        User user = new User();
        user.setUserName(userName);
        user.setPassword(encodedPassword);
        user.setSalt(salt);
        return user;
    }


    @RequestMapping("adminAddUserAction/{rid}")
    public ModelAndView adminAddUser(@RequestParam("userName") String userName, @RequestParam("password1") String password1, @RequestParam("password2") String password2,
                                     @PathVariable("rid") int rid) {
        String errInfo = getErrorInfo(userName, password1, password2);
        if (errInfo != "") {
            ModelAndView mav = new ModelAndView("manageAddUser");
            mav.addObject("errorInfo", errInfo);
            return mav;
        }
        User user = getUser(userName, password1);
        user.setRid(rid);
        userService.add(user);
        ModelAndView modelAndView = new ModelAndView("redirect:/manageUser/" + rid);
        return modelAndView;
    }

    private String getErrorInfo(@RequestParam("userName") String userName, @RequestParam("password1") String password1, @RequestParam("password2") String password2) {
        String errInfo = "";
        //是否返回注册
        userName = userName.trim();
        if (userName == "" || password1 == "" || password2 == "") {
            errInfo = "用户名或密码不能为空";
        } else if (null != userService.getByUserName(userName)) {
            errInfo = "用户名已存在";
        } else if (!password1.equals(password2)) {
            errInfo = "两次密码不一致";

        }
        return errInfo;
    }


    @RequestMapping("deleteUser/{id}")
    public ModelAndView deleteUser(@PathVariable("id") int id, HttpSession session) {
        userService.delete(id);
        int rid = (int) session.getAttribute("rid");
        ModelAndView mav = new ModelAndView("redirect:/manageUser/" + rid);
        return mav;
    }


    @RequestMapping("editUser/{id}")
    public ModelAndView editUser(@PathVariable("id") int id) {
        User user = userService.get(id);
        ModelAndView mav = new ModelAndView("manageEditUser");
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("updateUser")
    public ModelAndView updateUser(@RequestParam("id") int id, @RequestParam("password1") String password1, @RequestParam("password2") String password2, HttpSession session) {
        if (password1.equals(password2)) {
            User user = userService.get(id);
            user = encryption(user, password1);
            userService.update(user);
            return new ModelAndView("redirect:/manageUser/1");
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/editUser/" + id);
            modelAndView.addObject("errorInfo", "两次密码不一致,请重新输入!");
            return modelAndView;
        }

    }

    private User encryption(User user, String password1) {
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";
        String encodedPassword = new SimpleHash(algorithmName, password1, salt, times).toString();
        user.setPassword(encodedPassword);
        user.setSalt(salt);
        return user;
    }

    @RequestMapping("loginAction")
    public ModelAndView loginAction(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpSession session) {
        User user = userService.getByUserName(userName);
        if (null != user) {
            String passwordInDB = user.getPassword();
            String salt = user.getSalt();
            String passwordEncoded = new SimpleHash("md5", password, salt, 2).toString();
            if (passwordEncoded.equals(passwordInDB)) {
                Page page = new Page();
                int total = productService.countByCid(1);
                page.setTotal(total);
                page.setPageCount(total / page.getCount());
                page.calculateLast(total);
                List<Product> products = productService.listByCidByCount(page);
                session.setAttribute("products", products);
                session.setAttribute("page", page);
                session.setAttribute("user", user);
                // 2是管理员用户
                if (user.getRid() == 1) {
                    ModelAndView modelAndView = new ModelAndView("redirect:/home");
                    return modelAndView;
                } else {
                    ModelAndView modelAndView = new ModelAndView("redirect:/manage");
                    return modelAndView;
                }
            }
        }
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("errorInfo", "登录失败,用户名或密码错误");
        return modelAndView;
    }


}