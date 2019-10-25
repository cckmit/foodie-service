package com.foodie.portal.web.model;

import com.foodie.portal.article.repository.ArticleEntity;
import com.foodie.portal.city.City;
import com.foodie.portal.restaurant.repository.RestaurantEntity;
import lombok.Data;

@Data
public class RestaurantRepresentation {
    private String id;
    private String title;
    private String subTitle;
    private String images;
    private String content;
    private double price;
    private String cityName;

    public static RestaurantRepresentation from(RestaurantEntity entity) {
        return RestaurantRepresentationMapper.INSTANCE.from(entity);
    }

}
