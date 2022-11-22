package com.example.web.controller;

import com.example.web.DTO.UserDTO;
import com.example.web.pojo.Blog;
import com.example.web.service.BlogService;
import com.example.web.service.Impl.BlogServiceImpl;
import com.example.web.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;
    @GetMapping("blog")//页面的url地址
    public String blog(Model model)//对应函数
    {
        UserDTO user = UserHolder.getUser();
        Blog blog = blogService.getBlogByIdAndUser(1, user.getUserId());
        List<Blog> list = blogService.getAllBlog();
//        model.addAttribute("blogList",list);
        model.addAttribute("blog1",list.get(0));
        model.addAttribute("blog2",list.get(1));
        model.addAttribute("blog3",list.get(2));
        model.addAttribute("username",user.getUsername());
        model.addAttribute("introduction",user.getIntroduction());
//        model.addAttribute("blog1.title",blog.getTitle());
//        model.addAttribute("blog1.content",blog.getContent());
//        model.addAttribute("blog1.date",blog.getCreateTime());
        return "blog";//与templates中index.html对应
    }
//    @RequestMapping("/blog")
//    public String getBlog() {
//        Blog blog = blogService.getBlogByIdAndUser(1,1);
//        return blog.getContent();
//    }
//
//    @RequestMapping("/blog2")
//    public String getAllBlog() {
//        List<Blog> list = blogService.getAllBlog();
//        return list.toString();
//    }
//
//    @RequestMapping("/blog1")
//    public String insertBlog() {
//        blogService.insertBlog();
//        return "success1";
//    }


}
