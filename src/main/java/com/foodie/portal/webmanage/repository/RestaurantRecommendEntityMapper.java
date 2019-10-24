package com.foodie.portal.webmanage.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.webmanage.model.ArticleRecommend;
import com.foodie.portal.webmanage.model.RestaurantRecommend;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantRecommendEntityMapper extends BaseMapper<RestaurantRecommend, RestaurantRecommendEntity> {

    RestaurantRecommendEntityMapper instance = Mappers.getMapper(RestaurantRecommendEntityMapper.class);

}
