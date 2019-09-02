package com.foodie.portal.order;

import com.foodie.portal.activity.Activity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateOrderCommand {
    private Activity activity;
    private int count;
    private BigDecimal price;
}
