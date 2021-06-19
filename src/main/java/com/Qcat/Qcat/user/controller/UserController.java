package com.Qcat.Qcat.user.controller;

import com.Qcat.Qcat.user.dto.UserDto;
import com.Qcat.Qcat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

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
        session.getAttribute("login_id");


        return "/admin/board";
    }

    @PostMapping("/checkLoginAdmin")
    public String getLoginSession(UserDto dto, HttpSession session){
        session.setAttribute("login_id",dto.getLogin_id());
        return "redirect:/market/menuList/1";
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
