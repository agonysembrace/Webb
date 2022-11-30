package com.example.web.controller;

import com.example.web.service.BlogService;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/30 15:20
 * @Decription:存储Service的自动装配
 */
public class BaseController {

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;
}
