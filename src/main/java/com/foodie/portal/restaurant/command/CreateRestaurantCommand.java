package com.foodie.portal.restaurant.command;

import com.foodie.portal.restaurant.model.RestaurantType;
import com.foodie.portal.restaurant.model.SetMeal;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CreateRestaurantCommand {
    private String title;
    private String subTitle;
    private String images;
    private String content;
    private double price;
    private String cityId;
    private List<SetMeal> setMeals;
    @NotNull
    private RestaurantType type;
}
