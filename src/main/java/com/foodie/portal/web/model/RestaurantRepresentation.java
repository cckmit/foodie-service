package com.foodie.portal.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.commons.utils.JsonUtils;
import com.foodie.portal.restaurant.model.SetMeal;
import com.foodie.portal.restaurant.repository.RestaurantEntity;
import com.foodie.portal.web.po.RestaurantRepresentationPo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Objects;

@Data
@Accessors(chain = true)
public class RestaurantRepresentation {
    private String id;
    private String title;
    private String subTitle;
    private List<SetMeal> setMeals;
    private String images;
    private String content;
    private String cityName;
    private String area;
    private String address;
    private boolean favourite;

    public Double getPrice() {
        return setMeals.stream().mapToDouble(SetMeal::getPrice).min().getAsDouble();
    }

    public static RestaurantRepresentation from(RestaurantEntity entity) {
        return RestaurantRepresentationMapper.INSTANCE.from(entity);
    }

    public static RestaurantRepresentation from(RestaurantRepresentationPo entity) {
        return new RestaurantRepresentation()
                .setId(entity.getId())
                .setSetMeals(JsonUtils.toBean(entity.getSetMeals(), new TypeReference<List<SetMeal>>() {}))
                .setAddress(entity.getAddress())
                .setCityName(entity.getCityName())
                .setArea(entity.getArea())
                .setContent(entity.getContent())
                .setImages(entity.getImages())
                .setSubTitle(entity.getSubTitle())
                .setTitle(entity.getTitle());
    }

}
