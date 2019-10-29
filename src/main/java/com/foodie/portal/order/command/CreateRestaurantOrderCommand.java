package com.foodie.portal.order.command;

import com.foodie.portal.order.model.OrderInfo;
import lombok.Data;

@Data
public class CreateRestaurantOrderCommand {
    private String restaurantId;
    private String reserveDate;
    private String setMealName;
    private int count;
    private OrderInfo orderInfo;
}
