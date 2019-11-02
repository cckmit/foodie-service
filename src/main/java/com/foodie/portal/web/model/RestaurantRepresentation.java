package com.foodie.portal.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private List<SetMeal> setMeals;
    @JsonIgnore
    private String setMealsStr;
    private String images;
    private String content;
    private String cityName;
    private String address;
    private boolean favourite;

    public List<SetMeal> getSetMeals() {
        return JsonUtils.toBean(this.setMealsStr, new TypeReference<List<SetMeal>>() {});
    }

    public Double getPrice() {
       this.setMeals = JsonUtils.toBean(this.setMealsStr, new TypeReference<List<SetMeal>>() {
        });
        return setMeals.stream().mapToDouble(SetMeal::getPrice).min().getAsDouble();
    }

    public static RestaurantRepresentation from(RestaurantEntity entity) {
        return RestaurantRepresentationMapper.INSTANCE.from(entity);
    }

}
