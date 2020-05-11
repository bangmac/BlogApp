package com.bmv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameWriter;
    private String content;
    private String title;
    private java.sql.Date time;

    public Blog(){}

    public Blog(String nameWriter, String content, Date time) {
        this.nameWriter = nameWriter;
        this.content = content;
        this.time = time;
    } // tạo mới ko cần ID cho contructor này

    public Blog(String nameWriter, String content, String title, Date time) {
        this.nameWriter = nameWriter;
        this.content = content;
        this.title = title;
        this.time = time;
    }

    public Blog(Long id, String nameWriter, String content, String title, Date time) {
        this.id = id;
        this.nameWriter = nameWriter;
        this.content = content;
        this.title = title;
        this.time = time;
    }

    public Blog(Long id, String nameWriter, String content, Date time) {
        this.id = id;
        this.nameWriter = nameWriter;
        this.content = content;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameWriter() {
        return nameWriter;
    }

    public void setNameWriter(String nameWriter) {
        this.nameWriter = nameWriter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
