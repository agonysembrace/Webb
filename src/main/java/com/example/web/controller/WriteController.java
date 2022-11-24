package com.example.web.controller;

import com.example.web.DTO.LoginDTO;
import com.example.web.DTO.Result;
import com.example.web.DTO.UserDTO;
import com.example.web.mapper.BlogMapper;
import com.example.web.pojo.Blog;
import com.example.web.service.BlogService;
import com.example.web.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/23 19:53
 * @Decription:
 */
@Controller
public class WriteController {

    @Autowired
    BlogService blogService;

    @GetMapping("write")//页面的url地址
    public String getwrite(Model model)//对应函数
    {
        UserDTO userDTO = UserHolder.getUser();
        model.addAttribute("user",userDTO);
        return "write";//与templates中index.html对应
    }

    @RequestMapping(value = "blogwrite" ,method = RequestMethod.POST)
    public String writeBlog(@RequestParam("topic")String topic ,
                        @RequestParam("content")String content){
        UserDTO user = UserHolder.getUser();
        blogService.insertBlog(topic,content,LocalDateTime.now(),user.getUserId());
        return "redirect:index";
    }
}
