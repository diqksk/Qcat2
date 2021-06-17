package com.Qcat.Qcat.market.service;

import com.Qcat.Qcat.market.domain.Criteria;
import com.Qcat.Qcat.market.dto.MenuDto;
import com.Qcat.Qcat.market.repository.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    MenuMapper menuMapper;

    @Override
    public int insertMenu(MenuDto dto) {
        return menuMapper.insertMenu(dto);
    }

    @Override
    public List<MenuDto> getMenus(int store_id) {
        List<MenuDto> dto = menuMapper.getMenus(store_id);
        return menuMapper.getMenus(store_id);
    }


    @Override
    public List<MenuDto> getCatMenu(MenuDto dto) {
        return menuMapper.getCatMenu(dto);
    }

    @Override
    public List<MenuDto> getPaging(MenuDto dto, Criteria cri) {
        return menuMapper.getPaging(dto,cri);
    }

    @Override
    public List<HashMap<String, Object>> getCategoryCount(int store_id) {
        return menuMapper.getCategoryCount(store_id);
    }

}
