package br.com.dasa.mirror.api.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;

public class JsonHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonHelper.class);

    private static ObjectMapper mapper = new ObjectMapper()
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    public static <T> Optional<T> fromJson(String json, Class<T> genericClass) {
        try {
            return Optional.ofNullable(mapper.readValue(json, genericClass));
        } catch (IOException e) {
            LOGGER.error("Erro [" + e.getMessage() + "] ao fazer o parser: " + json);
            return Optional.empty();
        }
    }

    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("ERRO");
        }
    }
}
