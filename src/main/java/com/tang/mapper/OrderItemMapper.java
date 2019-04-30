/**
 * @author: tang gao liang
 * @time:2019/4/22 9:23:20
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.mapper;

import com.tang.pojo.OrderItem;

import java.util.Date;
import java.util.List;

public interface OrderItemMapper {

    int add(OrderItem orderItem);

    void delete(int id);

    void createOrder(int uid);

    OrderItem get(int id);

    Integer ifInCart(int uid, int pid);

    OrderItem getByUidAndPid(int uid, int pid);

    List<OrderItem> listByCartByUid(int uid);

    int update(OrderItem orderItem);

    List<OrderItem> listByCart();

    List<OrderItem> listByOrderAndUid(int uid);


}
