package com.foodie.portal.order.dto;

import com.foodie.portal.order.model.RestaurantOrder;
import com.foodie.portal.restaurant.model.RestaurantType;
import lombok.Data;

@Data
public class RestaurantOrderInfoDto {

    private String restaurantImages;
    private String restaurantTitle;
    private RestaurantType restaurantType;
    private int count;
    private double price;
    private double unitPrice;
    private String serviceDate;
    private String startTime;
    private String number;
    private String payNo;
    private String email;

    public static RestaurantOrderInfoDto from(RestaurantOrder order) {
        return RestaurantOrderInfoDtoMapper.INSTANCE.from(order);
    }
}
