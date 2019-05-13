/**
 * @author: tang gao liang
 * @time:2019/4/18 12:43:21
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.service.impl;


import com.tang.mapper.GroupBuyMapper;
import com.tang.pojo.GroupBuy;
import com.tang.service.GroupBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupBuyServiceImpl implements GroupBuyService {
    @Override
    public GroupBuy inGroup(int pid) {
        return groupBuyMapper.inGroup(pid);
    }

    @Autowired
    GroupBuyMapper groupBuyMapper;

    @Override
    public List<GroupBuy> list() {
        return groupBuyMapper.list();
    }

    @Override
    public void add(GroupBuy c) {
        groupBuyMapper.add(c);

    }

    @Override
    public void update(GroupBuy c) {
        groupBuyMapper.update(c);
    }

    @Override
    public void delete(int id) {
        groupBuyMapper.delete(id);
    }

    @Override
    public GroupBuy get(int id) {
        return groupBuyMapper.get(id);
    }


}