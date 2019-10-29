package com.foodie.portal.order.representation;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.order.model.RestaurantOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantOrderRepresentationMapper extends BaseMapper<RestaurantOrder, RestaurantOrderSummaryRepresentation> {

    RestaurantOrderRepresentationMapper instance = Mappers.getMapper(RestaurantOrderRepresentationMapper.class);

    @Override
    @Mapping(source = "restaurant.title", target = "restaurantTitle")
    @Mapping(source = "restaurant.address", target = "restaurantAddress")
    @Mapping(source = "restaurant.images", target = "restaurantImages")
    RestaurantOrderSummaryRepresentation from(RestaurantOrder from);
}
