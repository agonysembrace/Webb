package com.example.web.controller;

import com.example.web.DTO.LoginDTO;
import com.example.web.DTO.Result;
import com.example.web.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/17 19:54
 * @Decription:
 */

//@ResponseBody
@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    UserService userService;

//    @RequestMapping("/login")
    @PostMapping("/login")
//    public Result Login(@RequestBody LoginDTO loginForm, HttpSession session){
//        return userService.login(loginForm, session);
//
//    }
    public String Login(@RequestParam("username")String username ,
                        @RequestParam("password")String password, HttpSession session){
         LoginDTO loginForm = new LoginDTO(username,password);
         Result result = userService.login(loginForm, session);
//         return "success";
        if(result.getErrorMsg()==null)
            return "redirect:/index";
        else
            return  "redirect:/login";
//        return "redirect:/index";
    }
}
