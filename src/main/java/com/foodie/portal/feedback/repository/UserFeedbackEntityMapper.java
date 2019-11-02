package com.foodie.portal.feedback.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.feedback.model.MerchantFeedback;
import com.foodie.portal.feedback.model.UserFeedback;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserFeedbackEntityMapper extends BaseMapper<UserFeedback, UserFeedbackEntity> {
    UserFeedbackEntityMapper INSTANCE = Mappers.getMapper(UserFeedbackEntityMapper.class);
}
