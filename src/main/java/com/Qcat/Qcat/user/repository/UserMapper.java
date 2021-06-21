package com.Qcat.Qcat.user.repository;

import com.Qcat.Qcat.market.domain.Criteria;
import com.Qcat.Qcat.market.dto.MenuDto;
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
    List<MenuDto> getTotalPaging(MenuDto dto, Criteria cri);
    List<MenuDto> getCatTotalPaging(MenuDto dto, Criteria cri);
    List<HashMap<String, Object>> getCategoryCount(int store_id);
    int getPageSize(int store_id);
    int updateProduct(HashMap<String, Object> json);
    int deleteMenu(HashMap<String, Object> json);
    int getCatPageSize(HashMap<String, Object> cate);
    String addLoginSession(String login_id);
    int insertResume(HashMap<String,Object> formData);
    int getResumeCount(int member_id);
}
