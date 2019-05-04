package com.tang.mapper;

import com.tang.pojo.Info;

import java.util.List;

public interface InfoMapper {

    int add(Info info);

    void delete(int id);

    Info get(int id);

    int update(Info info);

    List<Info> list(int uid);

    void defaultAddress(int uid);


}