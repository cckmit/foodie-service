package com.foodie.portal.restaurant.dto;

import com.foodie.portal.restaurant.model.Restaurant;
import com.foodie.portal.restaurant.model.RestaurantType;
import com.foodie.portal.restaurant.model.SetMeal;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class RestaurantDto {

    private String id;
    private String title;
    private String subTitle;
    private String images;
    private String content;
    private double price;
    private String cityName;
    private String area;
    private String address;
    private String cityId;
    private List<SetMeal> setMeals;
    private RestaurantType type;
    private Instant createdAt;

    public static RestaurantDto from(Restaurant restaurant) {
        return RestaurantDtoMapper.INSTANCE.from(restaurant);
    }

}
