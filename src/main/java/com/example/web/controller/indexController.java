package com.example.web.controller;

import com.example.web.DTO.UserDTO;
import com.example.web.pojo.Blog;
import com.example.web.pojo.User;
import com.example.web.service.BlogService;
import com.example.web.service.UserService;
import com.example.web.utils.UserHolder;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/21 18:41
 * @Decription:
*/
 @Controller
    public class indexController extends BaseController{

//    @Autowired
//    BlogService blogService;
//
//    @Autowired
//    UserService userService;
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
        return "forward:blog";//与templates中index.html对应
    }
    @GetMapping("change")//页面的url地址
    public String change(Model model)//对应函数
    {
        UserDTO user = UserHolder.getUser();
        model.addAttribute("author",user);
        model.addAttribute("visitor",user);

        return "change";//与templates中index.html对应
    }

    @PostMapping("changeInfo")
    public String changeInfo(@RequestParam("uploadImg") MultipartFile file,
                             @RequestParam("introduction") String introduction,
                             @RequestParam("username")String username,
                             @RequestParam("password")String password,
                             Model model) throws IOException {

            byte[] data=file.getBytes();
            UserDTO user = UserHolder.getUser();
            userService.updateAll(data, user.getUserId(), username, password, introduction);
            User usernew= userService.getUserById( user.getUserId());
            UserHolder.saveUser(new UserDTO(usernew.getUsername(),usernew.getUserId(),usernew.getIntroduction(),usernew.getHeadShot()));
            model.addAttribute("author",UserHolder.getUser());
            model.addAttribute("visitor",UserHolder.getUser());
            return "login";

    }


}

