package com.tang.service;

import com.tang.pojo.GroupBuy;

import java.util.List;

public interface GroupBuyService {

    List<GroupBuy> list();

    void add(GroupBuy c);

    void update(GroupBuy c);

    void delete(int id);

    GroupBuy get(int id);

    GroupBuy inGroup(int pid);

}