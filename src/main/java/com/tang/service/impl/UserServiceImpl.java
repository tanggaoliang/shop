/**
 * @author: tang gao liang
 * @time:2019/4/18 12:43:21
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.service.impl;


import com.tang.mapper.UserMapper;
import com.tang.pojo.User;
import com.tang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> list(int rid) {
        return userMapper.list(rid);
    }

    @Override
    public void add(User c) {
        userMapper.add(c);

    }

    @Override
    public void update(User c) {
        userMapper.update(c);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }

    @Override
    public User get(int id) {
        return userMapper.get(id);
    }

    @Override
    public User getByUserName(String userName) {
        return userMapper.getByUserName(userName);
    }
}