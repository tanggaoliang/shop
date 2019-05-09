/**
 * @author: tang gao liang
 * @time:2019/4/18 12:43:21
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.service.impl;


import com.tang.mapper.EvaluateMapper;
import com.tang.pojo.Evaluate;
import com.tang.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    EvaluateMapper evaluateMapper;

    @Override
    public List<Evaluate> list(int pid) {
        return evaluateMapper.list(pid);
    }

    @Override
    public void add(Evaluate c) {
        evaluateMapper.add(c);

    }

    @Override
    public void update(Evaluate c) {
        evaluateMapper.update(c);
    }

    @Override
    public void delete(int id) {
        evaluateMapper.delete(id);
    }

    @Override
    public Evaluate get(int id) {
        return evaluateMapper.get(id);
    }


}