package com.Qcat.Qcat.chat.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class OrderDto {
    private int order_id;
    private int member_id;
    private String member_nick = "없음";
    private Date order_regdate;
    private String comment = "없음";


}
