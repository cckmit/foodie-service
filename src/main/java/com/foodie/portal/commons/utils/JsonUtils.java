package com.foodie.portal.commons.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;

import java.io.IOException;
import java.util.Objects;

@Slf4j
public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJsonStr(Object obj) {
        if (Objects.isNull(obj)) {
            return "";
        }
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.warn("json parse error: {}", obj);
        }
        return "";
    }

    public static <T> T toBean(String jsonStr, TypeReference<T> typeReference) {
        if (Strings.isBlank(jsonStr)) {
            return null;
        }
        try {
            return objectMapper.readValue(jsonStr, typeReference);
        } catch (Exception e) {
            log.warn("json parse error: {}", jsonStr);
        }
        return null;
    }

    public static <T> T toBean(String jsonStr, Class<T> clazz) {
        if (Strings.isBlank(jsonStr)) {
            return null;
        }
        try {
            return objectMapper.readValue(jsonStr, clazz);
        } catch (Exception e) {
            log.warn("json parse error: {}", jsonStr);
        }
        return null;
    }
}
