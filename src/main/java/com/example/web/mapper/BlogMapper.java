package com.example.web.mapper;

import com.example.web.pojo.Blog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/15 20:32
 * @Decription:
 */

@Mapper
public interface BlogMapper {

    Blog getBlogByIdAndUser(int BlogId, int userId);

    List<Blog>getBlogByUserId(int userId);

//    @Delete("delete from tb_blog where id = 1")
    void InsertBlog(String blogTitle, String blogContent, LocalDateTime createTime,int userId);

    List<Blog> getAllBlog() ;

    Blog getBlogByBlogId(int blogId);

}