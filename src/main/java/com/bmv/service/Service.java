package com.bmv.service;

import com.bmv.model.Blog;

import java.util.List;

public interface Service <Blog>{
    List<Blog> findall();
    Blog findById(Long id);
    // trả về đối tượng T được tìm bởi Id của n
    Blog save(Blog t);
    void remove(Blog t);
}

