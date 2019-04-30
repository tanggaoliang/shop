package com.tang.service;

import com.tang.pojo.OrderItem;

import java.util.Date;
import java.util.List;

public interface OrderItemService {


    List<OrderItem> listByCart();

    void add(OrderItem c);

    void update(OrderItem c);

    void createOrder(int uid);

    void delete(int id);

    OrderItem get(int id);

    Integer ifInCart(int uid, int pid);

    OrderItem getByUidAndPid(int uid, int pid);

    List<OrderItem> listByCartByUid(int uid);

    List<OrderItem> listByOrder(int uid);


}