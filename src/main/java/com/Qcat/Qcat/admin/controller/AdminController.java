package com.Qcat.Qcat.admin.controller;

import com.Qcat.Qcat.admin.service.AdminService;
import com.Qcat.Qcat.market.domain.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/admin/acceptBoard/{page}")
    public String adminAcceptBoard(@PathVariable("page") int page, Model model){


        Criteria cri = new Criteria(page,9);
        int total = (int) Math.ceil(adminService.countTotalResume() * 1.0 / 9);
        List<HashMap<String, Object>> lists = adminService.getResumeList(cri);
        System.out.println(lists);
        System.out.println(total);

        model.addAttribute("lists", lists);
        model.addAttribute("total", total);
        return "/admin/adminAcceptBoard";
    }

    @PostMapping("/acceptResume")
    public String acceptResume(@RequestParam HashMap<String,String> formInfo){
        if (formInfo.get("전송").equals("수락")) {
            System.out.println("수락");
            adminService.createNewStore(formInfo);
            adminService.updateResumeRole(formInfo);
        } else {
            System.out.println("거절");
            adminService.refuseResume(formInfo);
        }

        return "redirect:/market/1";
    }
}
