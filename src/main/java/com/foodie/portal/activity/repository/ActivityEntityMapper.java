package com.foodie.portal.activity.repository;

import com.foodie.portal.activity.Activity;
import com.foodie.portal.commons.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActivityEntityMapper extends BaseMapper<Activity, ActivityEntity> {

    ActivityEntityMapper instance = Mappers.getMapper(ActivityEntityMapper.class);

    @Override
    @Mappings({
            @Mapping(target = "priceList", ignore = true),
            @Mapping(target = "serviceTime", ignore = true)
    })
    ActivityEntity from(Activity from);

    @Override
    @Mappings({
            @Mapping(target = "priceList", ignore = true),
            @Mapping(target = "serviceTime", ignore = true)
    })
    Activity to(ActivityEntity to);
}
