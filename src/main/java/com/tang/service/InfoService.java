package com.tang.service;

import com.tang.pojo.Info;

import java.util.List;

public interface InfoService {

    List<Info> list(int uid);

    void add(Info c);

    void update(Info c);

    void delete(int id);

    Info get(int id);

    void defaultAddress(int uid);

}