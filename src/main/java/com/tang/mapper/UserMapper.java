package com.tang.mapper;

import com.tang.pojo.User;

import java.util.List;

public interface UserMapper {

    public int add(User User);

    public void delete(int id);

    public User get(int id);

    public User getByUserName(String userName);

    public int update(User User);

    public List<User> list(int rid);

    public int total();

}