/**
 * @author: tang gao liang
 * @time:2019/4/17 19:59:00
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ViewController {
    @RequestMapping("/")
    public String index() {
        return "login";
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


    @RequestMapping("/changePassword")
    public String changePassword() {
        return "changePassword";
    }

    @RequestMapping("/addInfo")
    public String addInfo() {
        return "addInfo";
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

    @RequestMapping("/manage")
    public String manage() {
        return "manage";
    }

    @RequestMapping("/adminAddUser/{rid}")
    public ModelAndView adminAddUser(@PathVariable("rid") int rid) {
        ModelAndView modelAndView = new ModelAndView("manageAddUser");
        modelAndView.addObject("rid", rid);
        return modelAndView;
    }


}
