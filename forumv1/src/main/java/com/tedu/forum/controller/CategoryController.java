package com.tedu.forum.controller;

import com.tedu.forum.mapper.CategoryMapper;
import com.tedu.forum.pojo.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category/")
public class CategoryController {
    @Autowired
    CategoryMapper mapper;

    @RequestMapping("select")
    public List<Category> select(){
        return mapper.select();
    }

    @RequestMapping("delete")
    public int deleteById(int id){
        return  mapper.deleteById(id);
    }

    @RequestMapping("update")
    public int update(Category category){
        return mapper.update(category);
    }

    @RequestMapping("insert")
    public List<Category> insert(String name){
        mapper.insert(name);
        return mapper.select();
    }
}
