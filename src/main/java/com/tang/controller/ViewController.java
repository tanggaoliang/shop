/**
 * @author: tang gao liang
 * @time:2019/4/17 19:59:00
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ViewController {
    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping("/upload")
    public String upload() {
        return "upload";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/jump")
    public String jump() {
        return "redirect:/index";
    }

    @RequestMapping("/jump2")
    public String jump2() {
        return "redirect:/";
    }

    @RequestMapping("/user")
    public String user() {
        return "user";
    }

    @RequestMapping("/add")
    public String add() {
        return "add";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }


    @RequestMapping("/header")
    public String header() {
        return "header";
    }

    @RequestMapping("/info")
    public String info() {
        return "info";
    }

    @RequestMapping("/changePassword")
    public String changePassword() {
        return "changePassword";
    }

    @RequestMapping("/detail")
    public String detail() {
        return "detail";
    }

    @RequestMapping("/check")
    public ModelAndView check(HttpSession session) {
        Integer i = (Integer) session.getAttribute("count");
        if (i == null) {
            i = 0;
        }
        i++;
        session.setAttribute("count", i);
        ModelAndView modelAndView = new ModelAndView("check");

        return modelAndView;
    }


}
