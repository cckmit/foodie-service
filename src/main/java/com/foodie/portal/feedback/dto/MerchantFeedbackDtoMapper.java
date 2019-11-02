package com.foodie.portal.feedback.dto;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.feedback.model.MerchantFeedback;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MerchantFeedbackDtoMapper extends BaseMapper<MerchantFeedback, MerchantFeedbackDto> {
    MerchantFeedbackDtoMapper INSTANCE = Mappers.getMapper(MerchantFeedbackDtoMapper.class);

    @Override
    @Mapping(target = "merchantName" , source = "merchant.name")
    @Mapping(target = "merchantEmail", source = "merchant.email")
    MerchantFeedbackDto from(MerchantFeedback from);
}
