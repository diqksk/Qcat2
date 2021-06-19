package com.Qcat.Qcat.user.repository;

import com.Qcat.Qcat.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {
    int checkSignUp(HashMap<String, String> json);
    int insertSignUp(UserDto dto);
    int checkLogin(UserDto dto);
    List<HashMap<String, Object>> getStoreList(String login_id);
}
