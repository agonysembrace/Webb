package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/15 19:07
 * @Decription:
 */

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {
       return "success";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
