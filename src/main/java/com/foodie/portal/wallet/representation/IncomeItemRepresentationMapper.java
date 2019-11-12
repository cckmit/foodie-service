package com.foodie.portal.wallet.representation;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.wallet.repository.IncomeItemEntity;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.Instant;

@Mapper
public interface IncomeItemRepresentationMapper extends BaseMapper<IncomeItemRepresentation, IncomeItemEntity> {

    IncomeItemRepresentationMapper INSTANCE = Mappers.getMapper(IncomeItemRepresentationMapper.class);

}
