package com.bmv.controller;


import com.bmv.model.Blog;
import com.bmv.service.Service;
import com.bmv.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    Service service;

    @GetMapping("/home")
    public ModelAndView showBlogList(){
        ModelAndView modelAndView = new ModelAndView("hienthi");
        List<Blog> laydulieu = service.findall();
        modelAndView.addObject("laydulieu",laydulieu);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView creatBlog(){
        ModelAndView modelAndView = new ModelAndView("create");
        Blog blog = new Blog();
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("createblog") // nhiệm vụ lưu blog đc khởi tạo vào database và báo về cho client
    public ModelAndView sendBlog(@ModelAttribute Blog blog){
        ModelAndView modelAndView = new ModelAndView("create");
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        blog.setTime(date);
        Blog blog1=(Blog) service.save(blog);
        if (blog1!=null){
            modelAndView.addObject("message", "Them thanh cong");
        }else
            modelAndView.addObject("message", "them blog ko thanh cong");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView getFormEdit(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("edit");
        Blog blog = (Blog) service.findById(id);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/edit-blog")
    public ModelAndView sendEditFrom(@ModelAttribute Blog blog){
        ModelAndView modelAndView =new ModelAndView("edit");
       service.save(blog);
       return modelAndView;
    }
}
