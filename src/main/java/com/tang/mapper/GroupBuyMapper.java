package com.tang.mapper;

import com.tang.pojo.GroupBuy;

import java.util.List;

public interface GroupBuyMapper {

    int add(GroupBuy groupBuy);

    void delete(int id);

    GroupBuy get(int id);

    int update(GroupBuy groupBuy);

    List<GroupBuy> list();

    GroupBuy inGroup(int pid);

}