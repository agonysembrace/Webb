package com.example.web.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/17 20:37
 * @Decription:
 */

@Data
@AllArgsConstructor
public class UserDTO {

    String username;
    private int userId;
    private String introduction;
    byte[] headShot;

}
