package com.Qcat.Qcat.market.service;

import com.Qcat.Qcat.market.domain.Criteria;
import com.Qcat.Qcat.market.dto.MenuDto;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface MenuService {
    int insertMenu(MenuDto dto);
    List<MenuDto> getMenus(int store_id);
    List<MenuDto> getCatMenu(MenuDto dto);
    List<MenuDto> getPaging(MenuDto dto, Criteria cri);
    List<HashMap<String, Object>> getCategoryCount(int store_id);

}
