/**
 * @author: tang gao liang
 * @time:2019/4/18 12:43:21
 * @unique: 唐高亮LIANG
 * @qq:1440535574
 */
package com.tang.service.impl;


import com.tang.mapper.CategoryMapper;
import com.tang.pojo.Category;
import com.tang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }

    @Override
    public void add(Category c) {
        categoryMapper.add(c);

    }

    @Override
    public void update(Category c) {
        categoryMapper.update(c);
    }

    @Override
    public void delete(Category c) {
        categoryMapper.delete(c.getId());
    }

    @Override
    public Category get(int id) {
        return categoryMapper.get(id);
    }


}