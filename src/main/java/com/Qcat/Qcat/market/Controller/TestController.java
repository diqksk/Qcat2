package com.Qcat.Qcat.market.Controller;

import com.Qcat.Qcat.market.dto.MenuDto;
import com.Qcat.Qcat.market.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("menuList")
    public String getMenuLit(Model model){

        MenuDto dto = new MenuDto();
        dto.setStore_id(1);

        model.addAttribute("menuList",menuService.getMenus(dto));

        return "/market/marketDetail";
    }
}
