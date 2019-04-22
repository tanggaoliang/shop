package com.tang.service;

import com.tang.pojo.User;

import java.util.List;

public interface UserService {

    List<User> list();

    void add(User c);

    void update(User c);

    void delete(User c);

    User get(int id);

    User getByUserName(String userName);

}