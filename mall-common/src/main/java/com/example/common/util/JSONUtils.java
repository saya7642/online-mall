package com.example.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;


public class JSONUtils {

    private static ObjectMapper objectMapper = SpringUtil.getBean(ObjectMapper.class);

    public static String toJson(Object obj) {
        if(obj == null || obj instanceof String) {
            return (String) obj;
        }

        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T parse(String json, Class<T> type) {
        if (StringUtils.isEmpty(json) || type == null) {
            return null;
        }

        try {
            return objectMapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setObjectMapper(ObjectMapper objectMapper) {
        Assert.notNull(objectMapper, "ObjectMapper should not be null");
        JSONUtils.objectMapper = objectMapper;
        System.out.println("set objectMapper.....:" + objectMapper);
    }
}
