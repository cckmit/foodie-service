package com.foodie.portal.order.dto;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.order.model.RestaurantOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantOrderInfoDtoMapper extends BaseMapper<RestaurantOrder, RestaurantOrderInfoDto> {
    RestaurantOrderInfoDtoMapper INSTANCE = Mappers.getMapper(RestaurantOrderInfoDtoMapper.class);

    @Override
    @Mapping(target = "restaurantTitle", source = "restaurant.title")
    @Mapping(target = "restaurantImages", source = "restaurant.images")
    @Mapping(target = "restaurantType", source = "restaurant.type")
    @Mapping(target = "email", source = "user.email")
    RestaurantOrderInfoDto from(RestaurantOrder from);
}
