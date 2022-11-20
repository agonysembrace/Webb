package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/16 19:41
 * @Decription:
 */
    @Controller
    public class ThymeleafController {
        @GetMapping("index")//页面的url地址
        public String getindex(Model model)//对应函数
        {
            model.addAttribute("name","飞飞");
            return "index";//与templates中index.html对应
        }
    }

