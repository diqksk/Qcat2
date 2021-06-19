package com.Qcat.Qcat.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private int member_id;
    private String login_id;
    private String password;
    private String name;
    private String email;
    private String phone;
    private Date member_regdate;
    private int role;
}
