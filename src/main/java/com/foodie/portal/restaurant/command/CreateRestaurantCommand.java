package com.foodie.portal.restaurant.command;

import lombok.Data;

@Data
public class CreateRestaurantCommand {
    private String title;
    private String subTitle;
    private String images;
    private String content;
    private double price;
    private String cityId;
}
