package com.example.web.service.Impl;

import com.example.web.mapper.BlogMapper;
import com.example.web.pojo.Blog;
import com.example.web.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/15 20:42
 * @Decription:
 */
@Service("BlogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;
    @Override
    public Blog getBlogByIdAndUser(int BlogId,int userId) {
        Blog blog = blogMapper.getBlogByIdAndUser(BlogId,userId);
        return blog;
    }


    @Override
    public void insertBlog() {
        blogMapper.InsertBlog();
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogMapper.getAllBlog();
    }
}
