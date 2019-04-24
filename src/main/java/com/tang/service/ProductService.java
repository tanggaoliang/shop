package com.tang.service;

import com.tang.pojo.Product;

import java.util.List;

public interface ProductService {


    List<Product> listByCid(int cid);

    List<Product> listAll();

    void add(Product c);

    void update(Product c);

    void delete(Product c);

    Product get(int id);

     List<Product> listByName(String name);

}