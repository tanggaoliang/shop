/**
 * @author: tang gao liang
 * @time:2019/4/23 21:38:25
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.controller;

import com.tang.mapper.ProductMapper;
import com.tang.pojo.Product;
import com.tang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private ProductMapper productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/showCategory/{cid}")
    public ModelAndView showCategory(@PathVariable("cid") int cid) {
        ModelAndView mav = new ModelAndView("search");
        List<Product> products = productService.listByCid(cid);
        String categoryName = categoryService.get(cid).getName();
        mav.addObject("categoryName", categoryName);
        mav.addObject("products", products);
        return mav;
    }

    @RequestMapping(value = "/search")
    public ModelAndView showCategory(@RequestParam("name") String name) {
        List<Product> products = productService.listByName(name);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("products", products);
        return mav;
    }


}
