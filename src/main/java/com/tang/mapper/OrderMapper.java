package com.tang.mapper;

import com.tang.pojo.Order;

import java.util.List;

public interface OrderMapper {

    public int add(Order order);

    public void delete(int id);

    public Order get(int id);

    public int update(Order order);

    public List<Order> list();


}