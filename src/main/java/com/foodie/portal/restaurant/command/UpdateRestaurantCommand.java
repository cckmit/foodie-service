package com.foodie.portal.restaurant.command;

import com.foodie.portal.restaurant.RestaurantType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateRestaurantCommand {
    private String title;
    private String subTitle;
    private String images;
    private String content;
    private double price;
    private String cityId;
    @NotNull
    private RestaurantType type;
}
