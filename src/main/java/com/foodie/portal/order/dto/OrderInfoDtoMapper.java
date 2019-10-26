package com.foodie.portal.order.dto;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.order.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderInfoDtoMapper extends BaseMapper<Order, OrderInfoDto> {
    OrderInfoDtoMapper INSTANCE = Mappers.getMapper(OrderInfoDtoMapper.class);

    @Override
    @Mapping(target = "activityTitle", source = "activity.title")
    @Mapping(target = "activityImages", source = "activity.images")
    @Mapping(target = "activityType", source = "activity.type")
    @Mapping(target = "email", source = "user.email")
    OrderInfoDto from(Order from);
}
