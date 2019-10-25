package com.foodie.portal.web.model;

import com.foodie.portal.article.repository.ArticleEntity;
import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.restaurant.repository.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantRepresentationMapper extends BaseMapper<RestaurantEntity, RestaurantRepresentation> {

    RestaurantRepresentationMapper INSTANCE = Mappers.getMapper(RestaurantRepresentationMapper.class);

    @Override
    @Mapping(target = "cityName", source = "city.name")
    RestaurantRepresentation from(RestaurantEntity from);
}
