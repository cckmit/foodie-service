package com.foodie.portal.order;

import lombok.Data;

@Data
public class CreateOrderCommand {
    private String activityId;
    private int count;
}
