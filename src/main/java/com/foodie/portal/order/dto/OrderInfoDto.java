package com.foodie.portal.order.dto;

import com.foodie.portal.order.Order;
import lombok.Data;

@Data
public class OrderInfoDto {

    private String activityImages;
    private String activityTitle;
    private int count;
    private double price;
    private String serviceDate;
    private String startTime;
    private String number;
    private String payNo;
    private String email;

    public static OrderInfoDto from(Order order) {
        return OrderInfoDtoMapper.INSTANCE.from(order);
    }
}
