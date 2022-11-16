package com.example.web;

import com.example.web.mapper.BlogMapper;
import com.example.web.pojo.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WebApplicationTests {

    @Autowired
    BlogMapper blogMapper;
    @Test
    void contextLoads() {
        List<Blog> list = blogMapper.getAllBlog();
        for(Blog o :list){
            System.out.println(o);
        }

    }

}
