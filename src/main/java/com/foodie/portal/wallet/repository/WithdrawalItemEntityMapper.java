package com.foodie.portal.wallet.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.wallet.model.WithdrawalItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WithdrawalItemEntityMapper extends BaseMapper<WithdrawalItem, WithdrawalItemEntity> {
    WithdrawalItemEntityMapper INSTANCE = Mappers.getMapper(WithdrawalItemEntityMapper.class);

}
