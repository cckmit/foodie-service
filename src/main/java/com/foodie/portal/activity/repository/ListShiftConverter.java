package com.foodie.portal.activity.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.activity.model.ServiceScheduling;
import com.foodie.portal.activity.model.Shift;
import com.foodie.portal.commons.utils.JsonUtils;

import javax.persistence.AttributeConverter;
import java.util.List;

public class ListShiftConverter implements AttributeConverter<List<Shift>, String> {

    @Override
    public String convertToDatabaseColumn(List<Shift> attribute) {
        return JsonUtils.toJsonStr(attribute);
    }

    @Override
    public List<Shift> convertToEntityAttribute(String dbData) {
        return JsonUtils.toBean(dbData, new TypeReference<List<Shift>>() {
        });
    }
}
