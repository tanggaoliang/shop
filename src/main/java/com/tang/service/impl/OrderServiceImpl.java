/**
 * @author: tang gao liang
 * @time:2019/4/18 12:43:21
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.service.impl;


import com.tang.mapper.OrderMapper;
import com.tang.pojo.Order;
import com.tang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> list() {
        return orderMapper.list();
    }

    @Override
    public void add(Order c) {
        orderMapper.add(c);

    }

    @Override
    public void update(Order c) {
        orderMapper.update(c);
    }

    @Override
    public void delete(Order c) {
        orderMapper.delete(c.getId());
    }

    @Override
    public Order get(int id) {
        return orderMapper.get(id);
    }


}