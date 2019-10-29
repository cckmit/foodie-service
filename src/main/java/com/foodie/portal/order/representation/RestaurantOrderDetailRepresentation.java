package com.foodie.portal.order.representation;

import com.foodie.portal.order.model.OrderInfo;
import com.foodie.portal.order.model.OrderStatus;
import lombok.Data;

import java.time.Instant;

@Data
public class RestaurantOrderDetailRepresentation {

    private String id;
    private String number;
    private String restaurantTitle;
    private String restaurantImages;
    private String restaurantAddress;
    private String setMealName;
    private double totalPrice;
    protected double itemPrice;
    private String reserveDate;
    private OrderInfo orderInfo;
    private OrderStatus status;
    private String payNo;
    private Instant createdAt;
}
