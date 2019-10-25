package com.foodie.portal.restaurant.dto;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.restaurant.Restaurant;
import com.foodie.portal.restaurant.repository.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantDtoMapper extends BaseMapper<Restaurant, RestaurantDto> {
    RestaurantDtoMapper INSTANCE = Mappers.getMapper(RestaurantDtoMapper.class);

    @Override
    @Mapping(target = "cityName", source = "city.name")
    @Mapping(target = "cityId", source = "city.id")
    RestaurantDto from(Restaurant from);
}
