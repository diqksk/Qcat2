package com.Qcat.Qcat.user.service;

import com.Qcat.Qcat.user.dto.UserDto;
import com.Qcat.Qcat.user.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public int checkSignUp(HashMap<String, String> json) {
        return userMapper.checkSignUp(json);
    }

    @Override
    public int insertSignUp(UserDto dto) {
        return userMapper.insertSignUp(dto);
    }

    @Override
    public int checkLogin(UserDto dto) {
        return userMapper.checkLogin(dto);
    }

    @Override
    public List<HashMap<String, Object>> getStoreList(String login_id) {
        return userMapper.getStoreList(login_id);
    }
}