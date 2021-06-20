package com.Qcat.Qcat.market.dto;


import lombok.Data;

import java.sql.Date;

@Data
public class MenuDto {
    private int product_id;
    private int store_id;
    private String category;
    private String product_name;
    private String content;
    private int price;
    private String img;
    private String memo;
    private Date product_regdate;

}
