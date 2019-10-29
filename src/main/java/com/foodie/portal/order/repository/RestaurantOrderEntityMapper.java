package com.foodie.portal.order.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.commons.utils.JsonUtils;
import com.foodie.portal.order.model.Order;
import com.foodie.portal.order.model.OrderInfo;
import com.foodie.portal.order.model.RestaurantOrder;
import com.foodie.portal.restaurant.repository.RestaurantEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {RestaurantEntityMapper.class})
public interface RestaurantOrderEntityMapper extends BaseMapper<RestaurantOrder, RestaurantOrderEntity> {

    RestaurantOrderEntityMapper instance = Mappers.getMapper(RestaurantOrderEntityMapper.class);

    @Override
    @Mapping(target = "orderInfo", qualifiedByName = "toOrderInfo")
    RestaurantOrder to(RestaurantOrderEntity to);

    @Override
    @Mapping(target = "orderInfo", qualifiedByName = "fromOrderInfo")
    RestaurantOrderEntity from(RestaurantOrder from);

    @Named("toOrderInfo")
    default OrderInfo map(String orderInfo) {
        return JsonUtils.toBean(orderInfo, OrderInfo.class);
    }

    @Named("fromOrderInfo")
    default String map(OrderInfo orderInfo) {
        return JsonUtils.toJsonStr(orderInfo);
    }
}
