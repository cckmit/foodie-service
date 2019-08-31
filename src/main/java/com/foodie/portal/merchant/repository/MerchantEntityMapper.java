package com.foodie.portal.merchant.repository;

import com.foodie.portal.activity.Activity;
import com.foodie.portal.activity.repository.ActivityEntity;
import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.merchant.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MerchantEntityMapper extends BaseMapper<Merchant, MerchantEntity> {

    MerchantEntityMapper instance = Mappers.getMapper(MerchantEntityMapper.class);

}
