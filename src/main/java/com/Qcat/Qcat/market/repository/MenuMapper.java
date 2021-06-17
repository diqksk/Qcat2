package com.Qcat.Qcat.market.repository;

import com.Qcat.Qcat.market.domain.Criteria;
import com.Qcat.Qcat.market.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MenuMapper {

    int insertMenu(MenuDto dto);
    List<MenuDto> getMenus(int store_id);
    List<MenuDto> getCatMenu(MenuDto dto);
    List<MenuDto> getPaging(@Param("dto") MenuDto dto, @Param("cri") Criteria cri);
    List<HashMap<String, Object>> getCategoryCount(int store_id);

}
