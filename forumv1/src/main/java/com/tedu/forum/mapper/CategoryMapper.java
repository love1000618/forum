package com.tedu.forum.mapper;

import com.tedu.forum.pojo.entity.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> select();

    int deleteById(int id);

    int update(Category category);

    int insert(String name);
}
