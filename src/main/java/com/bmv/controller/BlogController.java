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
        //khởi tạo một ModelandViews với tên là hienthi ---> hienthi.html
        List<Blog> laydulieutuDataBase = service.findall();
        // lấy dữ liệu từ trong database ra lưu vào một biến với kiểu dữ liệu List
        modelAndView.addObject("InBienlaydulieuRaView",laydulieutuDataBase);
        // thêm đối tượng vừa được lấy ra mà lưu vào biến ở trên đưa vào modelAndView
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView creatBlog(){
        ModelAndView modelAndView = new ModelAndView("create");
        // khởi tạo một ModelAndViews mới là create.html
        Blog blog = new Blog();
        // tạo một đối tượng blog mới hiển thị ra cho người dùng để lưu dữ liệu người dùng
        // nhập vào trong database sau đó thêm đối tượng blog này vào ModelAndView
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("createblog")
    // gửi blog vừa được tạo ra ở trên lên service để lưu blog đc khởi tạo vào database và báo về cho client
    public ModelAndView saveBlog(@ModelAttribute Blog blog){
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
    // tạo form hiểm thị về cho người dùng sửa đổi dữ liệu đã được thiết lập trước đó
    public ModelAndView getFormEdit(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("edit");
        // khởi tạo một ModelAndView với tên là edit -->edit.html
        Blog blog = (Blog) service.findById(id);
        // khởi tạo một đối tượng blog để lưu dữ liệu người dùng nhập vào trên trang edit
        // sau đó đưa nó vào ModelAndView
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/editblog")
    // gửi đối tượng views người dùng vừa nhập vào lên database
    public ModelAndView sendEditFrom(@ModelAttribute Blog blog){
        ModelAndView modelAndView =new ModelAndView("edit");
        try{
            service.save(blog);
            modelAndView.addObject("message", "sua thanh cong");
        }catch (Exception e){
            modelAndView.addObject("message", "sua khong thanh cong");
        }
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    // tạo view trả về trang delete cho người dùng khi họ ấn vào nút delete
    public ModelAndView deleteForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("delete");
        Blog blog = (Blog) service.findById(id);
        modelAndView.addObject("blog",blog);
        // tạo một đối blog để lưu dữ liệu khi người dùng click vào đối tượng cần delete
        return modelAndView;
    }

    @PostMapping("/delete-blog")
    public ModelAndView deleteFinish(@ModelAttribute Blog blog){
        ModelAndView modelAndView = new ModelAndView("delete");
        try{
            service.remove(blog.getId());
            modelAndView.addObject("message", "xoa thanh cong");
        }catch (Exception e){
            modelAndView.addObject("message", "xoa khong thanh cong");
        }
        return modelAndView;
    }

}
