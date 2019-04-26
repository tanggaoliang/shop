package com.tang.service;

import com.tang.pojo.Order;

import java.util.List;

public interface OrderService {

    List<Order> list();

    void add(Order c);

    void update(Order c);

    void delete(Order c);

    Order get(int id);

}