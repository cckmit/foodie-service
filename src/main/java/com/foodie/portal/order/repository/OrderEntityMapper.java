package com.foodie.portal.order.repository;

import com.foodie.portal.city.City;
import com.foodie.portal.city.repository.CityEntity;
import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderEntityMapper extends BaseMapper<Order, OrderEntity> {

    OrderEntityMapper instance = Mappers.getMapper(OrderEntityMapper.class);

}
