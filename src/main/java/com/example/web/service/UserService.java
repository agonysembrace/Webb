package com.example.web.service;

import com.example.web.DTO.LoginDTO;
import com.example.web.DTO.Result;
import com.example.web.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/17 18:11
 * @Decription:
 */
public interface UserService {

    Result login(LoginDTO loginForm, HttpSession session);
}
