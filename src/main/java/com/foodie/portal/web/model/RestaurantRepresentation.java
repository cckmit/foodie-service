package com.foodie.portal.web.model;

import com.foodie.portal.restaurant.repository.RestaurantEntity;
import lombok.Data;

@Data
public class RestaurantRepresentation {
    private String id;
    private String title;
    private String subTitle;
    private String images;
    private String content;
    private Double price;
    private String cityName;
    private boolean favourite;

    public static RestaurantRepresentation from(RestaurantEntity entity) {
        return RestaurantRepresentationMapper.INSTANCE.from(entity);
    }

}
