package com.example.web.service.Impl;

import com.example.web.mapper.BlogMapper;
import com.example.web.mapper.ReplyMapper;
import com.example.web.mapper.UserMapper;
import com.example.web.pojo.Blog;
import com.example.web.pojo.Reply;
import com.example.web.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Autowired
    ReplyMapper replyMapper;

    @Autowired
    UserMapper userMapper;
    @Override
    public Blog getBlogByIdAndUser(int BlogId,int userId) {
        Blog blog = blogMapper.getBlogByIdAndUser(BlogId,userId);
        return blog;
    }

    @Override
    public void insertBlog(String blogTitle, String blogContent, LocalDateTime createTime, int userId) {
        blogMapper.InsertBlog(blogTitle,blogContent,createTime, userId);
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogMapper.getAllBlog();
    }

    @Override
    public List<Blog> getBlogByUserId(int userId) {
        return blogMapper.getBlogByUserId(userId);
    }

    @Override
    public Blog getBlogByBlogId(int blogId) {
        return blogMapper.getBlogByBlogId(blogId);
    }

    @Override
    public List<Reply> getReplyByBlogId(int blogId) {
        List<Reply> list = replyMapper.getReplyByBlogId(blogId);
        for(Reply reply : list){
            reply.setUser(userMapper.getUserById(reply.getUserId()));
        }
        return list;
    }


}
