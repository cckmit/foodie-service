package com.foodie.portal.web.service;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.web.model.ActivityRepresentation;
import org.mapstruct.factory.Mappers;

public interface ActivityRepresentationMapper extends BaseMapper<Activity, ActivityRepresentation> {

    ActivityRepresentationMapper INSTANCE = Mappers.getMapper(ActivityRepresentationMapper.class);
}
