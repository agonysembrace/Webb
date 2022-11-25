package com.example.web.controller;

import com.example.web.DTO.UserDTO;
import com.example.web.pojo.Blog;
import com.example.web.pojo.User;
import com.example.web.service.BlogService;
import com.example.web.service.UserService;
import com.example.web.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/21 18:41
 * @Decription:
*/
 @Controller
    public class indexController {

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;
        @GetMapping("index")//页面的url地址
        public String getindex(Model model)//对应函数
        {
            UserDTO user = UserHolder.getUser();
            model.addAttribute("author",user);
            model.addAttribute("visitor",user);
            return "index";//与templates中index.html对应
        }

    @GetMapping("other")//页面的url地址
    public String getother(@RequestParam("authorId")int authorId,Model model)//对应函数
    {
        User author = userService.getUserById(authorId);
        UserDTO visitor = UserHolder.getUser();
        model.addAttribute("author",author);
        model.addAttribute("visitor",visitor);
        return "index";//与templates中index.html对应
    }
    }

