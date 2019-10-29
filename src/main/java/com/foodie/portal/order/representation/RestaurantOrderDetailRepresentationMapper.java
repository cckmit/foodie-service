package com.foodie.portal.order.representation;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.order.model.RestaurantOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantOrderDetailRepresentationMapper extends BaseMapper<RestaurantOrder, RestaurantOrderDetailRepresentation> {

    RestaurantOrderDetailRepresentationMapper instance = Mappers.getMapper(RestaurantOrderDetailRepresentationMapper.class);

    @Override
    @Mapping(source = "restaurant.title", target = "restaurantTitle")
    @Mapping(source = "restaurant.address", target = "restaurantAddress")
    @Mapping(source = "restaurant.images", target = "restaurantImages")
    RestaurantOrderDetailRepresentation from(RestaurantOrder from);
}
