package com.foodie.portal.restaurant.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.commons.utils.JsonUtils;
import com.foodie.portal.restaurant.model.Restaurant;
import com.foodie.portal.restaurant.model.SetMeal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RestaurantEntityMapper extends BaseMapper<Restaurant, RestaurantEntity> {
    RestaurantEntityMapper INSTANCE = Mappers.getMapper(RestaurantEntityMapper.class);

    @Override
    @Mapping(target = "setMeals", qualifiedByName = "toSetMeals")
    Restaurant to(RestaurantEntity to);

    @Override
    @Mapping(target = "setMeals", qualifiedByName = "fromSetMeals")
    RestaurantEntity from(Restaurant from);

    @Named("fromSetMeals")
    default String fromSetMeals(List<SetMeal> setMeals) {
        return JsonUtils.toJsonStr(setMeals);
    }

    @Named("toSetMeals")
    default List<SetMeal> toSetMeals(String setMeals) {
        return JsonUtils.toBean(setMeals, new TypeReference<List<SetMeal>>() {
        });
    }
}
