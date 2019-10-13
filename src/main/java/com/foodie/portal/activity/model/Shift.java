package com.foodie.portal.activity.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Shift {
    private String startTime;
    private int reserveCount;

    public Shift(String startTime) {
        this.startTime = startTime;
    }

    public void addReserveCount(int count){
        reserveCount = reserveCount + count;
    }

    public static Shift create(String startTime) {
        return new Shift(startTime);
    }
}
