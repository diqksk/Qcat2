package com.Qcat.Qcat.market.Controller;

import com.Qcat.Qcat.market.domain.Criteria;
import com.Qcat.Qcat.market.dto.MenuDto;
import com.Qcat.Qcat.market.dto.PageDTO;
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

        MenuDto dto = new MenuDto();

        dto.setContent("콘텐트연습");
        dto.setImg("/upload/img.png");
        dto.setCategory("치킨");
        dto.setPrice(5000);
        dto.setProduct_name("맛난치킨");
        dto.setStore_id(1);


        return "/market/register";
    }

    @PostMapping("/insertMenu")
    public String insertMenu(MenuDto dto){

        System.out.println(menuService.insertMenu(dto));

        return "/market/register";
    }

    @GetMapping("/menuList/{store_id}")
    public String getMenuLit(@PathVariable("store_id") int store_id, Model model){

        System.out.println(store_id);
        MenuDto dto = new MenuDto();
        dto.setStore_id(store_id);
        model.addAttribute("menuList",menuService.getMenus(dto));

        return "/market/marketDetail";
    }

    @GetMapping("/menuDetailList/{category}/{store_id}/{page}")
    public String getMenuLit(@PathVariable("store_id") int store_id
            ,@PathVariable("category") String category
                             ,@PathVariable("page") int page
                             ,Model model){

        System.out.println(store_id);
        MenuDto dto = new MenuDto();
        dto.setStore_id(store_id);
        dto.setCategory(category);

        int amount = 5;


        Criteria cri = new Criteria(page,amount);
        int total=(int)Math.ceil(menuService.getCatMenu(dto).size()*1.0/amount);
        System.out.println(total+"토탈탈탈");
        
        model.addAttribute("menuList",menuService.getPaging(dto,cri));
        model.addAttribute("total", total);

        return "/market/marketCategoryDetail";
    }
}
