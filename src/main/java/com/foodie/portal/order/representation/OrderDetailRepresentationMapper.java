package com.foodie.portal.order.representation;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDetailRepresentationMapper extends BaseMapper<Order, OrderDetailRepresentation> {

    OrderDetailRepresentationMapper instance = Mappers.getMapper(OrderDetailRepresentationMapper.class);

    @Override
    @Mapping(source = "activity.title", target = "activityTitle")
    @Mapping(source = "merchant.name", target = "merchantName")
    OrderDetailRepresentation from(Order from);
}
