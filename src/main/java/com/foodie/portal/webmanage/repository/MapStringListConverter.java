package com.foodie.portal.webmanage.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.commons.utils.JsonUtils;

import javax.persistence.AttributeConverter;
import java.util.List;
import java.util.Map;

public class MapStringListConverter implements AttributeConverter<Map<String,List<String>>, String> {
    @Override
    public String convertToDatabaseColumn(Map<String,List<String>> attribute) {
        return JsonUtils.toJsonStr(attribute);
    }

    @Override
    public Map<String,List<String>> convertToEntityAttribute(String dbData) {
        return JsonUtils.toBean(dbData, new TypeReference<Map<String,List<String>>>() {
        });
    }
}
