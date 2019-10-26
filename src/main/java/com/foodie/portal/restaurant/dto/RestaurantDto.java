package com.foodie.portal.restaurant.dto;

import com.foodie.portal.restaurant.model.Restaurant;
import com.foodie.portal.restaurant.model.RestaurantType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private String cityId;
    private RestaurantType type;
    private Date createdAt;

    public static RestaurantDto from(Restaurant restaurant) {
        return RestaurantDtoMapper.INSTANCE.from(restaurant);
    }

}
