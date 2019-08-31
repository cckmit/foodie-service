package com.foodie.portal.activity.repository;

import com.foodie.portal.activity.Activity;
import com.foodie.portal.commons.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActivityEntityMapper extends BaseMapper<Activity, ActivityEntity> {

    ActivityEntityMapper instance = Mappers.getMapper(ActivityEntityMapper.class);

}
