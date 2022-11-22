package com.example.web.utils;

import com.example.web.DTO.UserDTO;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/22 13:20
 * @Decription:
 */
public class UserHolder {
    private static final ThreadLocal<UserDTO> tl = new ThreadLocal<>();

    public static void saveUser(UserDTO user){
        tl.set(user);
    }

    public static UserDTO getUser(){
        return tl.get();
    }

    public static void removeUser(){
        tl.remove();
    }
}
