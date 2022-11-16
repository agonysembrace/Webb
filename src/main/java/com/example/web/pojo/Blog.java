package com.example.web.pojo;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/15 20:29
 * @Decription:
 */

@Data
public class Blog {
    private int id;
    private String Title;
    private String Content;
    private int UserId;
    private int blogId;
    private LocalDateTime CreateTime;
}
