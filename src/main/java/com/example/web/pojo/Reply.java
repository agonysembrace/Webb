package com.example.web.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/23 13:14
 * @Decription:
 */
@Data
public class Reply {
    private int blogId;
    private int userId;
    private User user;
    private LocalDateTime replyTime;
    private String content;
}
