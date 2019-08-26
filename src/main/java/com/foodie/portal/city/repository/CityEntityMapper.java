package com.foodie.portal.city.repository;

import com.foodie.portal.city.City;
import com.foodie.portal.commons.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityEntityMapper extends BaseMapper<City, CityEntity> {

    CityEntityMapper instance = Mappers.getMapper(CityEntityMapper.class);

}
