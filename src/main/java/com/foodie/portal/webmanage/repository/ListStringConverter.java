package com.foodie.portal.webmanage.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.commons.utils.JsonUtils;

import javax.persistence.AttributeConverter;
import java.util.List;

public class ListStringConverter implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return JsonUtils.toJsonStr(attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return JsonUtils.toBean(dbData, new TypeReference<List<String>>() {
        });
    }
}
