package com.foodie.portal.restaurant.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.restaurant.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantEntityMapper extends BaseMapper<Restaurant, RestaurantEntity> {
    RestaurantEntityMapper INSTANCE = Mappers.getMapper(RestaurantEntityMapper.class);
}
