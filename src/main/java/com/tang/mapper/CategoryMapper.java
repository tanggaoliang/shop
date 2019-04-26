package com.tang.mapper;

import com.tang.pojo.Category;

import java.util.List;

public interface CategoryMapper {

    int add(Category category);

    void delete(int id);

    Category get(int id);

    int update(Category category);

    List<Category> list();


}