/**
 * @author: tang gao liang
 * @time:2019/4/22 10:09:30
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.test;

import com.tang.mapper.ProductMapper;
import com.tang.pojo.Category;
import com.tang.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-transaction-full.xml")
public class ProductTest {
    @Autowired
    ProductMapper productMapper;

    @Test
    public void insert() {
        List<Product> products = productMapper.listByCid(1);
        for (Product product : products) {
            System.out.println(product);
        }

    }
}


