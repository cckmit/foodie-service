package com.foodie.portal.order.command;

import com.foodie.portal.order.OrderInfo;
import lombok.Data;

@Data
public class CreateOrderCommand {
    private String activityId;
    private int count;
    private OrderInfo orderInfo;
}
