package com.foodie.portal.wallet.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.order.repository.ActivityOrderEntityMapper;
import com.foodie.portal.wallet.model.IncomeItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ActivityOrderEntityMapper.class)
public interface IncomeItemEntityMapper extends BaseMapper<IncomeItem, IncomeItemEntity> {
    IncomeItemEntityMapper INSTANCE = Mappers.getMapper(IncomeItemEntityMapper.class);

}
