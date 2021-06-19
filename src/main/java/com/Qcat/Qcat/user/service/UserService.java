package com.Qcat.Qcat.user.service;

import com.Qcat.Qcat.user.dto.UserDto;

import java.util.HashMap;

public interface UserService{
    int checkSignUp(HashMap<String, String> json);
    int insertSignUp(UserDto dto);
    int checkLogin(UserDto dto);
}
