package com.foodie.portal.order.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.commons.utils.JsonUtils;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.order.model.OrderInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActivityOrderEntityMapper extends BaseMapper<Order, ActivityOrderEntity> {

    ActivityOrderEntityMapper instance = Mappers.getMapper(ActivityOrderEntityMapper.class);

    @Override
    @Mapping(target = "orderInfo", qualifiedByName = "toOrderInfo")
    Order to(ActivityOrderEntity to);

    @Override
    @Mapping(target = "orderInfo", qualifiedByName = "fromOrderInfo")
    ActivityOrderEntity from(Order from);

    @Named("toOrderInfo")
    default OrderInfo map(String orderInfo) {
        return JsonUtils.toBean(orderInfo, OrderInfo.class);
    }

    @Named("fromOrderInfo")
    default String map(OrderInfo orderInfo) {
        return JsonUtils.toJsonStr(orderInfo);
    }
}
