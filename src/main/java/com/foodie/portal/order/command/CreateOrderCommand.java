package com.foodie.portal.order.command;

import com.foodie.portal.order.OrderInfo;
import lombok.Data;

import java.util.Date;

@Data
public class CreateOrderCommand {
    private String activityId;
    private String serviceDate;
    private String startTime;
    private int count;
    private OrderInfo orderInfo;
}
