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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-transaction-full.xml")
public class ProductTest {
    @Autowired
    ProductMapper productMapper;

    @Test
    public void insert() {
        Product product = new Product();
        Category category = new Category();
        category.setId(1);
        for (int i = 1; i < 21; i++) {
            product.setName("product " + i);
            product.setFileName("peijian2");
            product.setPrice(i * 100);
            product.setInfo("product info " + i);
            product.setCategory(category);
            productMapper.add(product);

        }
    }

}
