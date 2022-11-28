package com.example.web.mapper;

import com.example.web.pojo.Blog;
import com.example.web.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/15 20:32
 * @Decription:
 */

@Mapper
public interface UserMapper {

    User getUserById(int userId);
    Void insertImg(byte[] img);
    User getUserByUsername(String username);

    Void createUser(String username ,String password);
//    User  getImgByUserId(int userId);
}