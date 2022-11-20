package com.example.web.service;

import com.example.web.pojo.Blog;

import java.util.List;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/15 20:42
 * @Decription:
 */
public interface BlogService {
    Blog getBlogByIdAndUser(int BlogId,int userId);
    void insertBlog();
    List<Blog> getAllBlog();
}
