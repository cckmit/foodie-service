package com.foodie.portal.wallet.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.wallet.MerchantWallet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MerchantWalletEntityMapper extends BaseMapper<MerchantWallet, MerchantWalletEntity> {
    MerchantWalletEntityMapper INSTANCE = Mappers.getMapper(MerchantWalletEntityMapper.class);

}
