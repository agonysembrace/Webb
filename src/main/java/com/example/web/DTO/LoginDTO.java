package com.example.web.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/17 20:20
 * @Decription:用于存储Login对线
 */

@Data
@AllArgsConstructor
public class LoginDTO {

    private String username;
    private String password;
}
