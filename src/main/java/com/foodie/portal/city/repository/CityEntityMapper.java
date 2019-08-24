package com.foodie.portal.city.repository;

import com.foodie.portal.city.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityEntityMapper {

    CityEntityMapper instance = Mappers.getMapper(CityEntityMapper.class);

    City to(CityEntity cityEntity);

    CityEntity from(City city);

    List<City> to(List<CityEntity> cityEntities);
}
