package com.foodie.portal.activity.repository;

import com.foodie.portal.activity.model.ServiceScheduling;
import com.foodie.portal.commons.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceSchedulingEntityMapper extends BaseMapper<ServiceScheduling, ServiceSchedulingEntity> {

    ServiceSchedulingEntityMapper instance = Mappers.getMapper(ServiceSchedulingEntityMapper.class);

}
