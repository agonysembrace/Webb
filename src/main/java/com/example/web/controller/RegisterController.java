package com.example.web.controller;

import com.example.web.DTO.LoginDTO;
import com.example.web.mapper.UserMapper;
import com.example.web.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/28 19:32
 * @Decription:
 */

@Controller
public class RegisterController {
    @Autowired
    UserService userService;

    @GetMapping("register")
    public String register(){
        return  "register";
    }


    @RequestMapping(value = "registerForm",method = RequestMethod.POST)
    public String registerForm(@RequestParam("username")String username ,
                               @RequestParam("password")String password,
                               @RequestParam("passwordAgain") String passwordAgain,
                               HttpSession session , Model model){

        if(!Objects.equals(password, passwordAgain)) {
            model.addAttribute("msg", "两次密码不一致");
            return "msg";
        }
        if(userService.containUsername(username)) {
            model.addAttribute("msg", "重复的用户名");
            return "msg";
        }


        userService.createUser(username,password);
        LoginDTO loginDTO = new LoginDTO(username,password);
        userService.login(loginDTO,session);
        return "login";
    }

    @GetMapping("login")
    public String login1(){
        return "login";
    }

    @GetMapping("msg")
    public String msg(){
        return "msg";
    }
}
