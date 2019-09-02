package com.foodie.portal.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateOrderCommand {
    private String activityId;
    private int count;
    private BigDecimal price;
}
