package com.Qcat.Qcat.market.repository;

import com.Qcat.Qcat.market.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    int insertMenu(MenuDto dto);
    List<MenuDto> getMenus(MenuDto dto);
}
