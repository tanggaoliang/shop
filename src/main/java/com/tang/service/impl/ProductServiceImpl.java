/**
 * @author: tang gao liang
 * @time:2019/4/18 12:43:21
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.service.impl;


import com.tang.mapper.ProductMapper;
import com.tang.pojo.Category;
import com.tang.pojo.Product;
import com.tang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> listByName(String name) {
        return productMapper.listByName(name);
    }

    @Override
    public List<Product> listByCid(int cid) {
        return productMapper.listByCid(cid);
    }

    @Override
    public List<Product> listAll() {
        return productMapper.listAll();
    }

    @Override
    public void add(Product c) {
        productMapper.add(c);

    }

    @Override
    public void update(Product c) {
        productMapper.update(c);
    }

    @Override
    public void delete(Product c) {
        productMapper.delete(c.getId());
    }

    @Override
    public Product get(int id) {
        return productMapper.get(id);
    }


}