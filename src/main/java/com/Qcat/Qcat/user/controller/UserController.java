package com.Qcat.Qcat.user.controller;

import com.Qcat.Qcat.user.dto.UserDto;
import com.Qcat.Qcat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String getLoginPage(){
        return "/user/login";
    }

    @GetMapping("/admin/board")
    public String getMyRestaurant(Model model, HttpSession session){
        List<HashMap<String,Object>> lists =userService.getStoreList((String) session.getAttribute("login_id"));
        model.addAttribute("lists", lists);
        return "/user/board";
    }

    @PostMapping("/checkLoginAdmin")
    public String getLoginSession(UserDto dto, HttpSession session){
        System.out.println(dto.getLogin_id());
        session.setAttribute("login_id",dto.getLogin_id());
        return "redirect:/admin/board";
    }

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "/user/signUp";
    }

    @PostMapping("/signUpForm")
    public String getSignUpForm(UserDto dto){
        userService.insertSignUp(dto);

        return "redirect:/admin/signUp";
    }
}
