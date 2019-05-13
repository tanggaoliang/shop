package com.tang.service;

import com.tang.pojo.Evaluate;

import java.util.List;

public interface EvaluateService {

    List<Evaluate> list(int pid);

    List<Evaluate> listAll();

    void add(Evaluate c);

    void update(Evaluate c);

    void delete(int id);

    Evaluate get(int id);


}