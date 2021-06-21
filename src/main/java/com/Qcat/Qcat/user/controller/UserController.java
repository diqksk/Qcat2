package com.Qcat.Qcat.user.controller;

import com.Qcat.Qcat.market.domain.Criteria;
import com.Qcat.Qcat.market.dto.MenuDto;
import com.Qcat.Qcat.user.dto.UserDto;
import com.Qcat.Qcat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/logout")
    public String getLogOutPage(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }


    @GetMapping("/admin/board")
    public String getMyRestaurant(Model model, HttpSession session){
        List<HashMap<String,Object>> lists =userService.getStoreList((String) session.getAttribute("login_id"));
        int resumeCount = userService.getResumeCount(Integer.parseInt((String) session.getAttribute("member_id")));

        if(session.getAttribute("login_id").equals("admin")){
            return "redirect:/admin/acceptBoard/1";
        }

        if(lists.size()==0 && resumeCount == 0){
            return "/user/board";
        }else if(lists.size()==0 && resumeCount >0) {
            return "/user/resumeResultPage";
        }else{
            System.out.println(lists.get(0).get("store_id"));
            session.setAttribute("store_id",lists.get(0).get("store_id"));
            model.addAttribute("lists", lists);
            return "/user/board";
        }
    }

    @PostMapping("/checkLoginAdmin")
    public String getLoginSession(UserDto dto, HttpSession session){
        System.out.println(dto.getLogin_id());
        session.setAttribute("login_id",dto.getLogin_id());
        session.setAttribute("member_id",userService.addLoginSession((String)session.getAttribute("login_id")));
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

    @GetMapping("/admin/storeDetail/{store_id}/{page}")
    public String getMenuList(@PathVariable("store_id") int store_id, @PathVariable("page") int page, Model model, HttpServletRequest request){

        String category = request.getParameter("category");

        MenuDto dto = new MenuDto();
        dto.setStore_id(store_id);

        int amount = 10;

        Criteria cri = new Criteria(page, amount);

        if(category == null){
            int total = (int) Math.ceil(userService.getPageSize(store_id) * 1.0 / amount);
            model.addAttribute("lists", userService.getTotalPaging(dto, cri));
            model.addAttribute("total", total);
            System.out.println(total);
        }else{
            dto.setCategory(category);
            HashMap<String, Object> cate = new HashMap<String, Object>();
            cate.put("cate", category);
            cate.put("store_id", store_id);
            int total = (int) Math.ceil(userService.getCatPageSize(cate) * 1.0 / amount);
            model.addAttribute("lists", userService.getCatTotalPaging(dto, cri));
            model.addAttribute("total", total);

        }
        model.addAttribute("category", userService.getCategoryCount(store_id));
        model.addAttribute("store_id", store_id);

        return "/user/menuListBoard";
    }

    @PostMapping("/admin/submitResume")
    public String submitResume(@RequestParam HashMap<String,Object> formData, HttpSession session){
        formData.put("member_id", session.getAttribute("member_id"));
        System.out.println(formData);
        userService.insertResume(formData);
        return "redirect:/admin/board";
    }
}
