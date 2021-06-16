package com.Qcat.Qcat.market.service;

import com.Qcat.Qcat.market.dto.MenuDto;

import java.util.List;

public interface MenuService {
    int insertMenu(MenuDto dto);
    List<MenuDto> getMenus(MenuDto dto);
}
