package com.bmv.repository;

import com.bmv.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    // truyền tham số kiểu dữ liệu (Blog,Long)để ánh xạo đối tuong Blog trng model thành một bảng trong database
}
