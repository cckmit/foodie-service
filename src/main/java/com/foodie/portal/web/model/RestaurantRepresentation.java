package com.foodie.portal.web.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.commons.utils.JsonUtils;
import com.foodie.portal.restaurant.model.SetMeal;
import com.foodie.portal.restaurant.repository.RestaurantEntity;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantRepresentation {
    private String id;
    private String title;
    private String subTitle;
    private String setMeals;
    private String images;
    private String content;
    private String cityName;
    private boolean favourite;

    public Double getPrice() {
        List<SetMeal> setMeals = JsonUtils.toBean(this.setMeals, new TypeReference<List<SetMeal>>() {
        });
        return setMeals.stream().mapToDouble(SetMeal::getPrice).min().getAsDouble();
    }

    public static RestaurantRepresentation from(RestaurantEntity entity) {
        return RestaurantRepresentationMapper.INSTANCE.from(entity);
    }

}
