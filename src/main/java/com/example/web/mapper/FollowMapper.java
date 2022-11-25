package com.example.web.mapper;

import com.example.web.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/25 13:56
 * @Decription:
 */

    @Mapper
    public interface FollowMapper {
        List<Integer> getAllFollowerByUserId(int userId);

    }

