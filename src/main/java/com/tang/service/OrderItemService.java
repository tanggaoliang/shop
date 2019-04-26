package com.tang.service;

import com.tang.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> listByOrder();

    List<OrderItem> listByCart();

    void add(OrderItem c);

    void update(OrderItem c);

    void delete(OrderItem c);

    OrderItem get(int id);

    List<OrderItem> listByCartByUid(int uid);


}