package com.Qcat.Qcat.chat.dto;

import lombok.Data;

@Data
public class OrderDetailDto {
    private int detail_id;
    private int product_id;
    private int order_id;
    private int value;
}
