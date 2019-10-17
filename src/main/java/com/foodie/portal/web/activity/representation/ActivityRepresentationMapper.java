package com.foodie.portal.web.activity.representation;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.commons.BaseMapper;
import org.mapstruct.factory.Mappers;

public interface ActivityRepresentationMapper extends BaseMapper<Activity, ActivityRepresentation> {

    ActivityRepresentationMapper INSTANCE = Mappers.getMapper(ActivityRepresentationMapper.class);
}
