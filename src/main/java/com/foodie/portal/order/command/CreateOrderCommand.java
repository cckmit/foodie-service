package com.foodie.portal.order.command;

import com.foodie.portal.order.model.OrderInfo;
import lombok.Data;

@Data
public class CreateOrderCommand {
    private String activityId;
    private String serviceDate;
    private String startTime;
    private int count;
    private OrderInfo orderInfo;
}
