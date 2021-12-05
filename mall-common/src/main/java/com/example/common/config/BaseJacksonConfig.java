package com.example.common.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public abstract class BaseJacksonConfig {

    @Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
    private String dateFormat;

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customLocalDateTImeSerializerCustomizer() {
        return builder -> {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
            builder.serializerByType(LocalDateTime.class, localDateTimeSerializer(dateTimeFormatter));
            builder.deserializerByType(LocalDateTime.class, localDateTimeDeserializer(dateTimeFormatter));
        };
    }

    public LocalDateTimeSerializer localDateTimeSerializer(DateTimeFormatter formatter) {
        return new LocalDateTimeSerializer(formatter);
    }

    public LocalDateTimeDeserializer localDateTimeDeserializer(DateTimeFormatter formatter) {
        return new LocalDateTimeDeserializer(formatter);
    }


}
