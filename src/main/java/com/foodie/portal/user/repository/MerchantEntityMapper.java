package com.foodie.portal.user.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.user.model.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MerchantEntityMapper extends BaseMapper<Merchant, MerchantEntity> {

    MerchantEntityMapper instance = Mappers.getMapper(MerchantEntityMapper.class);

}
