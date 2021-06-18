package com.Qcat.Qcat.chat.service;

import com.Qcat.Qcat.chat.dto.OrderDetailDto;
import com.Qcat.Qcat.chat.dto.OrderDto;
import com.Qcat.Qcat.chat.repository.ChatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    ChatMapper chatMapper;


    @Override
    public int getLastOrder() {
        return chatMapper.getLastOrder();
    }

    @Override
    public int insertOrder(OrderDto dto) {
        return chatMapper.insertOrder(dto);
    }

    @Override
    public int insertOrderDetail(OrderDetailDto dto) {
        return chatMapper.insertOrderDetail(dto);
    }

    @Override
    public List<Map<String, Object>> getBeforeOrders(int store_id) {
        return chatMapper.getBeforeOrders(store_id);
    }
}
