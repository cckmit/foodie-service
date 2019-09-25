package com.foodie.portal.activity.model;

import lombok.Data;

@Data
public class Shift {
    private String startTime;
    private int reserveCount;

    public void addReserveCount(int count){
        reserveCount = reserveCount + count;
    }
}
