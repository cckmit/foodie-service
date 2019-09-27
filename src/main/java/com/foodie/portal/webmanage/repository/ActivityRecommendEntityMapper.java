package com.foodie.portal.webmanage.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.webmanage.model.ActivityRecommend;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActivityRecommendEntityMapper extends BaseMapper<ActivityRecommend, ActivityRecommendEntity> {

    ActivityRecommendEntityMapper instance = Mappers.getMapper(ActivityRecommendEntityMapper.class);

}
