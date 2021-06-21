package com.Qcat.Qcat.user.service;

import com.Qcat.Qcat.market.domain.Criteria;
import com.Qcat.Qcat.market.dto.MenuDto;
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

    @Override
    public List<MenuDto> getTotalPaging(MenuDto dto, Criteria cri) {
        return userMapper.getTotalPaging(dto,cri);
    }

    @Override
    public List<HashMap<String, Object>> getCategoryCount(int store_id) {
        return userMapper.getCategoryCount(store_id);
    }

    @Override
    public int getPageSize(int store_id) {
        return userMapper.getPageSize(store_id);
    }

    @Override
    public int updateProduct(HashMap<String, Object> json) {
        return userMapper.updateProduct(json);
    }

    @Override
    public int deleteMenu(HashMap<String, Object> json) {
        return userMapper.deleteMenu(json);
    }

    @Override
    public int getCatPageSize(HashMap<String, Object> cate) {
        return userMapper.getCatPageSize(cate);
    }

    @Override
    public List<MenuDto> getCatTotalPaging(MenuDto dto, Criteria cri) {
        return userMapper.getCatTotalPaging(dto,cri);
    }

    @Override
    public String addLoginSession(String login_id) {
        return userMapper.addLoginSession(login_id);
    }

    @Override
    public int insertResume(HashMap<String, Object> formData) {
        return userMapper.insertResume(formData);
    }

    @Override
    public int getResumeCount(int member_id) {
        return userMapper.getResumeCount(member_id);
    }
}
