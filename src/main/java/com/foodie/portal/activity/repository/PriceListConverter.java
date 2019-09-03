package com.foodie.portal.activity.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.activity.model.ActivityPrice;
import com.foodie.portal.commons.utils.JsonUtils;

import javax.persistence.AttributeConverter;
import java.util.List;

public class PriceListConverter implements AttributeConverter<List<ActivityPrice>, String> {
    @Override
    public String convertToDatabaseColumn(List<ActivityPrice> attribute) {
        return JsonUtils.toJsonStr(attribute);
    }

    @Override
    public List<ActivityPrice> convertToEntityAttribute(String dbData) {
        return JsonUtils.toBean(dbData, new TypeReference<List<ActivityPrice>>() {});
    }
}
