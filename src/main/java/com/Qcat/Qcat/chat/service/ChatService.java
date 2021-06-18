package com.Qcat.Qcat.chat.service;


import com.Qcat.Qcat.chat.dto.OrderDetailDto;
import com.Qcat.Qcat.chat.dto.OrderDto;

import java.util.List;
import java.util.Map;

public interface ChatService {
    int getLastOrder();
    int insertOrder(OrderDto dto);
    int insertOrderDetail(OrderDetailDto dto);
    List<Map<String, Object>> getBeforeOrders(int store_id);

}
