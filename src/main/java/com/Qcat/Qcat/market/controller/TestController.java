package com.Qcat.Qcat.market.controller;

import com.Qcat.Qcat.market.domain.Criteria;
import com.Qcat.Qcat.market.dto.MenuDto;
import com.Qcat.Qcat.market.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @Autowired
    MenuService menuService;

    @GetMapping("test")
    public String test(){

        return "/market/register";
    }

    @PostMapping("/insertMenu")
    public String insertMenu(MenuDto dto){

        System.out.println(menuService.insertMenu(dto));

        return "/market/register";
    }

    @GetMapping("/menuList/{store_id}")
    public String getMenuList(@PathVariable("store_id") int store_id, Model model){
        System.out.println(store_id);
        model.addAttribute("menuList",menuService.getMenus(store_id));
        model.addAttribute("categories",menuService.getCategoryCount(store_id));
        System.out.println("여기서나는에런가?1");
        model.addAttribute("store_id", store_id);
        System.out.println("여기서나는에런가2");
        return "/market/marketDetail";
    }

    @GetMapping("/menuDetailList/{category}/{store_id}/{page}")
    public String getMenuDetailList(@PathVariable("store_id") int store_id
            , @PathVariable("category") String category
            , @PathVariable("page") int page
            , Model model
    ) {

        MenuDto dto = new MenuDto();
        dto.setStore_id(store_id);
        dto.setCategory(category);

        int amount = 5;


        Criteria cri = new Criteria(page, amount);
        int total = (int) Math.ceil(menuService.getCatMenu(dto).size() * 1.0 / amount);


        model.addAttribute("menuList", menuService.getPaging(dto, cri));
        model.addAttribute("total", total);
        model.addAttribute("store_id", store_id);

        return "/market/marketCategoryDetail";
    }
}
