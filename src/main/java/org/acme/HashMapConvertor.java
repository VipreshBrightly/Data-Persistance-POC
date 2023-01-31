package org.acme;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.json.JsonObject;

import javax.persistence.AttributeConverter;
import java.util.Map;

public class HashMapConvertor implements AttributeConverter<Map<String, Object>, JsonObject> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public JsonObject convertToDatabaseColumn(Map<String, Object> anotherJson) {
        if(anotherJson==null)
            return null;
        return new JsonObject(anotherJson);
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(JsonObject dbData) {
        if (dbData == null) {
            return null;
        }
        return dbData.getMap();
    }


}
