package com.Qcat.Qcat.user.controller;

import com.Qcat.Qcat.user.dto.UserDto;
import com.Qcat.Qcat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserAjaxController {

    @Autowired
    UserService userService;

    @PostMapping("/checkSignUp")
    public boolean checkSignUp(@RequestBody HashMap<String,String> json){

        System.out.println(json);
        int checkedResult = userService.checkSignUp(json);
        System.out.println(checkedResult);

        if(checkedResult == 0){
            return true;
        }
        return false;
    }

    @PostMapping("/checkLogin")
    public boolean checkLogin(@RequestBody UserDto dto) {
        int result=userService.checkLogin(dto);


        if(result!=0){
            return true;
        }else{
            return false;
        }

    }

}
