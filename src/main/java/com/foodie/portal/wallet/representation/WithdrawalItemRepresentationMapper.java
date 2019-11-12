package com.foodie.portal.wallet.representation;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.wallet.repository.IncomeItemEntity;
import com.foodie.portal.wallet.repository.WithdrawalItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WithdrawalItemRepresentationMapper extends BaseMapper<WithdrawalRepresentation, WithdrawalItemEntity> {

    WithdrawalItemRepresentationMapper INSTANCE = Mappers.getMapper(WithdrawalItemRepresentationMapper.class);

}
