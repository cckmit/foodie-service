package com.foodie.portal.web.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.activity.model.ActivityPrice;
import com.foodie.portal.activity.repository.ActivityEntity;
import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.commons.utils.JsonUtils;
import org.apache.commons.collections.CollectionUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ActivityDetailRepresentationMapper extends BaseMapper<ActivityEntity, ActivityDetailRepresentation> {

    ActivityDetailRepresentationMapper INSTANCE = Mappers.getMapper(ActivityDetailRepresentationMapper.class);

    @Override
    @Mapping(target = "cityName", source = "city.name")
    @Mapping(target = "price" ,source = "priceList", qualifiedByName = "toPrice")
    ActivityDetailRepresentation from(ActivityEntity from);

    @Named("toPrice")
    default double toPrice(List<ActivityPrice> priceList) {
        if(CollectionUtils.isEmpty(priceList)) {
            return 0;
        }
        return priceList.stream().mapToDouble(ActivityPrice::getPrice).min().getAsDouble();
    }
}
