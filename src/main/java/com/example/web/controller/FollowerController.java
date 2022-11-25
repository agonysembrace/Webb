package com.example.web.controller;

import com.example.web.DTO.UserDTO;
import com.example.web.pojo.User;
import com.example.web.service.UserService;
import com.example.web.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/25 13:59
 * @Decription:
 */
@Controller
public class FollowerController {

    @Autowired
    UserService userService;

    @GetMapping("subscribe")
    public String subscribe(@RequestParam("authorId") int authorId, Model model){
        UserDTO user = UserHolder.getUser();
        User author = userService.getUserById(authorId);
        List<User> followerList = userService.getFollowerByUserId(author.getUserId());
        model.addAttribute("followerList",followerList);
        model.addAttribute("author",author);
        model.addAttribute("visitor",user);
        return "subscribe";
    }
}
