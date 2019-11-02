package com.foodie.portal.web.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.commons.utils.JsonUtils;
import com.foodie.portal.restaurant.model.SetMeal;
import com.foodie.portal.restaurant.repository.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RestaurantRepresentationMapper extends BaseMapper<RestaurantEntity, RestaurantRepresentation> {

    RestaurantRepresentationMapper INSTANCE = Mappers.getMapper(RestaurantRepresentationMapper.class);

    @Override
    @Mapping(target = "cityName", source = "city.name")
    @Mapping(target = "setMeals" ,qualifiedByName = "toSetMeals")
    RestaurantRepresentation from(RestaurantEntity from);

    @Override
    @Mapping(target = "setMeals" ,qualifiedByName = "fromSetMeals")
    RestaurantEntity to(RestaurantRepresentation to);

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
