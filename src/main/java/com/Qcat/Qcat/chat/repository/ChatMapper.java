package com.Qcat.Qcat.chat.repository;


import com.Qcat.Qcat.chat.dto.OrderDetailDto;
import com.Qcat.Qcat.chat.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface ChatMapper {
    int getLastOrder();
    int insertOrder(OrderDto dto);
    int insertOrderDetail(OrderDetailDto dto);
    List<Map<String, Object>> getBeforeOrders(int store_id);


}
