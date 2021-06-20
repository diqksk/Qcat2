package com.Qcat.Qcat.user.service;

import com.Qcat.Qcat.market.domain.Criteria;
import com.Qcat.Qcat.market.dto.MenuDto;
import com.Qcat.Qcat.user.dto.UserDto;

import java.util.HashMap;
import java.util.List;

public interface UserService{
    int checkSignUp(HashMap<String, String> json);
    int insertSignUp(UserDto dto);
    int checkLogin(UserDto dto);
    List<HashMap<String, Object>> getStoreList(String login_id);
    List<MenuDto> getTotalPaging(MenuDto dto, Criteria cri);
    List<HashMap<String, Object>> getCategoryCount(int store_id);
    int getPageSize(int store_id);
    int updateProduct(HashMap<String, Object> json);
    int deleteMenu(HashMap<String, Object> json);

}
