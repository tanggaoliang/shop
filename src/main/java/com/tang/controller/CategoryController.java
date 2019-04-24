package com.tang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tang.pojo.Category;
import com.tang.pojo.Product;
import com.tang.service.CategoryService;
import com.tang.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("listCategory")
    public ModelAndView listCategory(Page page) {
        ModelAndView mav = new ModelAndView("listCategory");
        PageHelper.offsetPage(page.getStart(), 5);
        List<Category> cs = categoryService.list();
        int total = (int) new PageInfo<>(cs).getTotal();
        page.calculateLast(total);

        // 放入转发参数
        mav.addObject("cs", cs);
        System.out.println(mav);
        // 放入jsp路径

        return mav;
    }

    @RequestMapping("addCategory")
    public ModelAndView addCategory(Category category) {
        categoryService.add(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategory");
        return mav;
    }

    @RequestMapping("deleteCategory")
    public ModelAndView deleteCategory(Category category) {
        categoryService.delete(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategory");
        return mav;
    }

    @RequestMapping("editCategory")
    public ModelAndView editCategory(Category category) {
        Category c = categoryService.get(category.getId());
        ModelAndView mav = new ModelAndView("editCategory");
        mav.addObject("c", c);
        return mav;
    }

    @RequestMapping("updateCategory")
    public ModelAndView updateCategory(Category category) {
        categoryService.update(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategory");
        return mav;
    }



}