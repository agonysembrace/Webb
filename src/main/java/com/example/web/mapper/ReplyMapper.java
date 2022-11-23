package com.example.web.mapper;

import com.example.web.pojo.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/23 13:16
 * @Decription:
 */

@Mapper
public interface ReplyMapper {

    List<Reply> getReplyByBlogId(int blogId);

}


