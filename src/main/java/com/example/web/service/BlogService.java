package com.example.web.service;

import com.example.web.pojo.Blog;
import com.example.web.pojo.Reply;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/15 20:42
 * @Decription:
 */
public interface BlogService {
    Blog getBlogByIdAndUser(int BlogId,int userId);
//    void insertBlog();

    void insertBlog(String blogTitle, String blogContent, LocalDateTime createTime,int userId);
    void writeReply(int blogId , int userId, LocalDateTime replyTime,String content);

    List<Blog> getAllBlog();

    List<Blog> getBlogByUserId(int userId);

    Blog getBlogByBlogId(int blogId);

    List<Reply> getReplyByBlogId(int blogId);
}
