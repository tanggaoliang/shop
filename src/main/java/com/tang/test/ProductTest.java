/**
 * @author: tang gao liang
 * @time:2019/4/22 10:09:30
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.test;

import com.tang.mapper.OrderItemMapper;
import com.tang.mapper.ProductMapper;
import com.tang.pojo.Category;
import com.tang.pojo.OrderItem;
import com.tang.pojo.Product;
import com.tang.service.CategoryService;
import com.tang.service.OrderItemService;
import com.tang.service.ProductService;
import com.tang.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-transaction-full.xml")
public class ProductTest {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @Test
    public void query() {
        List <String> a=new ArrayList<>();
        a.add("321");
        a.add("321");
        a.add("321");
        System.out.println(a.size());
    }

}



