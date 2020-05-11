package com.bmv.service;

import com.bmv.model.Blog;

import java.util.List;

public interface Service <Blog>{
    List<Blog> findall();

    Blog findById(Long id);
    // trả về đối tượng T được tìm bởi Id của nó
    // Blog (List <Blog>) là kiểu dử liệu trả về của phương thức là một danh sách List chứa các đối tượng Blog

    Blog save(Blog t);

    void remove(Long id);
}

