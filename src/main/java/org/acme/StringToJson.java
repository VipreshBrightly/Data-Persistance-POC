package org.acme;

import io.vertx.core.json.JsonObject;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StringToJson implements AttributeConverter<String, JsonObject> {

    @Override
    public JsonObject convertToDatabaseColumn(String string) {
        if (string == null) {
            return null;
        }
        return new JsonObject(string);
    }

    @Override
    public String convertToEntityAttribute(JsonObject dbData) {

        if (dbData == null) {
            return null;
        }
        return dbData.encodePrettily();
    }
}
