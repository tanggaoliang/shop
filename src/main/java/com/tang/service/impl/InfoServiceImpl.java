/**
 * @author: tang gao liang
 * @time:2019/4/18 12:43:21
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.service.impl;


import com.tang.mapper.InfoMapper;
import com.tang.pojo.Info;
import com.tang.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    InfoMapper infoMapper;

    @Override
    public void defaultAddress(int uid) {
        infoMapper.defaultAddress(uid);
    }

    @Override
    public List<Info> list(int uid) {
        return infoMapper.list(uid);
    }

    @Override
    public void add(Info c) {
        infoMapper.add(c);

    }

    @Override
    public void update(Info c) {
        infoMapper.update(c);
    }

    @Override
    public void delete(int id) {
        infoMapper.delete(id);

    }

    @Override
    public Info get(int id) {
        return infoMapper.get(id);
    }


}