package com.Qcat.Qcat.market.service;

import com.Qcat.Qcat.market.domain.Criteria;
import com.Qcat.Qcat.market.dto.MenuDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService {
    int insertMenu(MenuDto dto);
    List<MenuDto> getMenus(MenuDto dto);
    List<MenuDto> getCatMenu(MenuDto dto);
    List<MenuDto> getPaging(MenuDto dto, Criteria cri);

}
