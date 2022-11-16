package com.example.web.mapper;

import com.example.web.pojo.Blog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

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

    @Delete("delete from tb_blog where id = 3")
    void InsertBlog();

    List<Blog> getAllBlog() ;

}