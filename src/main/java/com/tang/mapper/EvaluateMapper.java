package com.tang.mapper;

import com.tang.pojo.Evaluate;

import java.util.List;

public interface EvaluateMapper {

    int add(Evaluate evaluate);

    void delete(int id);

    Evaluate get(int id);

    void update(Evaluate evaluate);

    List<Evaluate> list(int pid);

    List<Evaluate> listAll();


}