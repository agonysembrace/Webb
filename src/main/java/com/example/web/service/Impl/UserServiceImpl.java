package com.example.web.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.example.web.DTO.LoginDTO;
import com.example.web.DTO.Result;
import com.example.web.DTO.UserDTO;
import com.example.web.mapper.FollowMapper;
import com.example.web.mapper.LoginMapper;
import com.example.web.mapper.UserMapper;
import com.example.web.pojo.User;
import com.example.web.service.UserService;
import com.example.web.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/17 18:28
 * @Decription:
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    FollowMapper followMapper;


    @Override
    public Result login( LoginDTO loginForm, HttpSession session) {
        //1. 校验手机号
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();


        //4.一致，根据手机号查询用户
        User user = loginMapper.Login(username,password);

        //5. 判断用户是否存在
        if (user == null){
            //6. 不存在，创建新用户
            return Result.fail("用户不存在或密码不正确");
        }

        //在此处向线程中添加用户是无效的，因为与拦截器中已不是同个线程，添加后无法在Usercontroller中获取到
//        UserHolder.saveUser(BeanUtil.copyProperties(user, UserDTO.class));

        //7.保存用户信息到session
        session.setAttribute("user", BeanUtil.copyProperties(user, UserDTO.class));
        System.out.println(session.getAttribute("user"));
        return Result.ok();

    }

    @Override
    public User getUserById(int userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public byte[] getImgByUserId(int userId) {
        User user = userMapper.getUserById(userId);
        byte[] headShot = user.getHeadShot();
        return headShot;
    }

    @Override
    public List<User> getFollowerByUserId(int userId){
        List<Integer> idList = followMapper.getAllFollowerByUserId(userId);
        List<User> followerList = new ArrayList<>();
        for(int i:idList){
            User follower = userMapper.getUserById(i);
            followerList.add(follower);
        }
        //得到的是id表，还要根据id查找用户表才对
        return followerList;
    }
}
