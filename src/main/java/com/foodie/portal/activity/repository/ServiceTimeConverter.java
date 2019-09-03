package com.foodie.portal.activity.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.activity.model.ActivityDateTime;
import com.foodie.portal.commons.utils.JsonUtils;

import javax.persistence.AttributeConverter;
import java.util.List;

public class ServiceTimeConverter implements AttributeConverter<List<ActivityDateTime>, String> {

    @Override
    public String convertToDatabaseColumn(List<ActivityDateTime> attribute) {
        return JsonUtils.toJsonStr(attribute);
    }

    @Override
    public List<ActivityDateTime> convertToEntityAttribute(String dbData) {
        return JsonUtils.toBean(dbData, new TypeReference<List<ActivityDateTime>>() {
        });
    }
}
