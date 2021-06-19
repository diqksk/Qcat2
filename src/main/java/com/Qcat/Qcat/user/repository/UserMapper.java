package com.Qcat.Qcat.user.repository;

import com.Qcat.Qcat.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface UserMapper {
    int checkSignUp(HashMap<String, String> json);
    int insertSignUp(UserDto dto);
    int checkLogin(UserDto dto);
}
