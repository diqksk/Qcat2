package com.Qcat.Qcat.market.service;

import com.Qcat.Qcat.market.domain.Criteria;
import com.Qcat.Qcat.market.dto.MenuDto;
import com.Qcat.Qcat.market.repository.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<MenuDto> getMenus(MenuDto dto) {
        return menuMapper.getMenus(dto);
    }

    @Override
    public List<MenuDto> getCatMenu(MenuDto dto) {
        return menuMapper.getCatMenu(dto);
    }

    @Override
    public List<MenuDto> getPaging(MenuDto dto, Criteria cri) {
        return menuMapper.getPaging(dto,cri);
    }
}
