package com.bmv.service.impl;

import com.bmv.model.Blog;
import com.bmv.repository.BlogRepository;
import com.bmv.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements Service<Blog> {

    @Autowired
    BlogRepository blogRepository;

    // service chỉ implement lại các thao tác nhiệp vụ từ interface service
    // muốn thao tác với database thì phải tiêm repository vào serveice

    @Override
    public List<Blog> findall() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public Blog save(Blog blog) {
        blogRepository.save(blog);
        Blog blog1=blog;
       return blog1;
    }

    @Override
    public void remove(Long id) {
        blogRepository.delete(id);
    }
}
