/**
 * @author: tang gao liang
 * @time:2019/4/18 12:43:21
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.service.impl;


import com.tang.mapper.OrderItemMapper;
import com.tang.pojo.OrderItem;
import com.tang.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItem> listByCart() {
        return orderItemMapper.listByCart();
    }

    @Override
    public List<OrderItem> listByOrder() {
        return orderItemMapper.listByOrder();
    }

    @Override
    public void add(OrderItem c) {
        orderItemMapper.add(c);

    }

    @Override
    public void update(OrderItem c) {
        orderItemMapper.update(c);
    }

    @Override
    public void delete(OrderItem c) {
        orderItemMapper.delete(c.getId());
    }

    @Override
    public OrderItem get(int id) {
        return orderItemMapper.get(id);
    }

    @Override
    public List<OrderItem> listByCartByUid(int uid) {
        return orderItemMapper.listByCartByUid(uid);
    }
}