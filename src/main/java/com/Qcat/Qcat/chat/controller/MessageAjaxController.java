package com.Qcat.Qcat.chat.controller;

import com.Qcat.Qcat.chat.dto.OrderDetailDto;
import com.Qcat.Qcat.chat.dto.OrderDto;
import com.Qcat.Qcat.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MessageAjaxController {


    @Autowired
    ChatService chatService;

    @GetMapping("/getOrderNum")
    public int getLastOrder(){
        return chatService.getLastOrder()+1;
    }

    @PostMapping("/insertOrder")
    public int insertNewOrder(OrderDto dto){
        return chatService.insertOrder(dto);
    }

    @PostMapping("/insertOrderDetail")
    public int insertNewOrderDetail(@RequestBody OrderDetailDto dto) {
        System.out.println(dto);
        return chatService.insertOrderDetail(dto);
    }

    @GetMapping("/getBeforeOrders")
    public List<Map<String,Object>> getBeforeOrders (int store_id){
        return chatService.getBeforeOrders(store_id);
    }
}
