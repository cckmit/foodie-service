package com.foodie.portal.order.model;

import com.foodie.portal.restaurant.model.Restaurant;
import lombok.Data;

@Data
public class RestaurantOrder extends Order {

    private Restaurant restaurant;
    private double price;
    private String reserveDate;
    private String payNo;
}
