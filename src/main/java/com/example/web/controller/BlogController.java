package com.example.web.controller;

import com.example.web.pojo.Blog;
import com.example.web.service.BlogService;
import com.example.web.service.Impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/15 21:02
 * @Decription:
 */
@ResponseBody
@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping("/blog")
    public String getBlog() {
        Blog blog = blogService.getBlogByIdAndUser(1,1);
        return blog.getContent();
    }

    @RequestMapping("/blog2")
    public String getAllBlog() {
        List<Blog> list = blogService.getAllBlog();
        return list.toString();
    }

    @RequestMapping("/blog1")
    public String insertBlog() {
        blogService.insertBlog();
        return "success1";
    }


}
