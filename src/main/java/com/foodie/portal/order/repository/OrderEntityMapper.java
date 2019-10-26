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
public interface OrderEntityMapper extends BaseMapper<Order, OrderEntity> {

    OrderEntityMapper instance = Mappers.getMapper(OrderEntityMapper.class);

    @Override
    @Mapping(target = "orderInfo", qualifiedByName = "toOrderInfo")
    Order to(OrderEntity to);

    @Override
    @Mapping(target = "orderInfo", qualifiedByName = "fromOrderInfo")
    OrderEntity from(Order from);

    @Named("toOrderInfo")
    default OrderInfo map(String orderInfo) {
        return JsonUtils.toBean(orderInfo, OrderInfo.class);
    }

    @Named("fromOrderInfo")
    default String map(OrderInfo orderInfo) {
        return JsonUtils.toJsonStr(orderInfo);
    }
}
