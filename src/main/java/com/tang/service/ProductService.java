package com.tang.service;

import com.tang.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> list();

    void add(Product c);

    void update(Product c);

    void delete(Product c);

    Product get(int id);

}