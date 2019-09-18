package com.foodie.portal.publicbenefit.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.publicbenefit.PublicBenefit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublicBenefitMapper extends BaseMapper<PublicBenefit, PublicBenefitEntity> {
    PublicBenefitMapper INSTANCE = Mappers.getMapper(PublicBenefitMapper.class);
}
