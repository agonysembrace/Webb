package com.example.web.service;

import com.example.web.DTO.LoginDTO;
import com.example.web.DTO.Result;
import com.example.web.pojo.User;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/17 18:11
 * @Decription:
 */
public interface UserService {

    Result login(LoginDTO loginForm, HttpSession session);

    User getUserById(int userId);

   byte[] getImgByUserId(int userId);

   List<User> getFollowerByUserId(int userId);

   void addNewFollowing(int userId, int authorId, LocalDateTime subTime);

   boolean FollowingOrNot(int userId, int authorId);

   void cancelFollow(int userId, int authorId);

   boolean containUsername(String username);

   void createUser(String username,String password);
}
