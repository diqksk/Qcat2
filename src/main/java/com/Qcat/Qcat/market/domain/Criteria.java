package com.Qcat.Qcat.market.domain;

import lombok.Data;

@Data
public class Criteria {

    private int pageNum;
    private int amount;
    private int offset;

    public Criteria(){
        this(1, 10);
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum-1;
        this.amount = amount;
        this.offset = (pageNum - 1) * amount;
    }
}
