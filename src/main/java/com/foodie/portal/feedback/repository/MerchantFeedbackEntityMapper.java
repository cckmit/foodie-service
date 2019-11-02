package com.foodie.portal.feedback.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.feedback.model.MerchantFeedback;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MerchantFeedbackEntityMapper extends BaseMapper<MerchantFeedback, MerchantFeedbackEntity> {
    MerchantFeedbackEntityMapper INSTANCE = Mappers.getMapper(MerchantFeedbackEntityMapper.class);
}
