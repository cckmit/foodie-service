package com.foodie.portal.activity.representation;

import com.foodie.portal.activity.model.ServiceScheduling;
import com.foodie.portal.activity.repository.ServiceSchedulingEntity;
import com.foodie.portal.commons.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceSchedulingMapper extends BaseMapper<ServiceScheduling, ServiceSchedulingEntity> {
    ServiceSchedulingMapper INSTANCE = Mappers.getMapper(ServiceSchedulingMapper.class);
}
