package com.foodie.portal.feedback.dto;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.feedback.model.UserFeedback;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserFeedbackDtoMapper extends BaseMapper<UserFeedback, UserFeedbackDto> {
    UserFeedbackDtoMapper INSTANCE = Mappers.getMapper(UserFeedbackDtoMapper.class);

}
