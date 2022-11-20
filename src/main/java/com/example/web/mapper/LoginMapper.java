package com.example.web.mapper;

import com.example.web.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/17 18:07
 * @Decription:
 */
@Mapper
public interface LoginMapper {
  //   User Login(@Param("username") String username, @Param("password") String password);
     User Login( String username,  String password);

}
