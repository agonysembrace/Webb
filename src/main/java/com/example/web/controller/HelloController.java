package com.example.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/15 19:07
 * @Decription:
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {
       return "index";
    }
}
