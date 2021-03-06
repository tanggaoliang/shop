package com.tang.service;

import com.tang.pojo.Product;
import com.tang.util.Page;

import java.util.List;

public interface ProductService {


    List<Product> listByCid(int cid);

    List<Product> listByCidByCount(Page page);

    List<Product> listByNameByPage(Page page);

    List<Product> listAll();

    void add(Product c);

    void update(Product c);

    void delete(int id);

    Product get(int id);

    List<Product> listByName(String name);

    int bigIndex();

    void insertOnlyId(int id);

    int countByCid(int cid);

}