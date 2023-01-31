package org.acme;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.vertx.core.json.JsonObject;

import javax.persistence.*;
import java.util.Map;

@Entity(name="Author")
public class Author extends PanacheEntityBase {

    @Id
    @Column(length=40, unique = true)
    @GeneratedValue
    Long id;

    @Column(columnDefinition = "json")
    @Convert(converter = StringToJson.class)
    String stringJson;

    JsonObject jsonObject;

    @Column(columnDefinition = "json")
    @Convert(converter = HashMapConvertor.class)
    Map<String, Object> jsonMap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStringJson() {
        return stringJson;
    }

    public void setStringJson(String stringJson) {
        this.stringJson = stringJson;
    }

    public JsonObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public Map<String, Object> getJsonMap() {
        return jsonMap;
    }

    public void setJsonMap(Map<String, Object> jsonMap) {
        this.jsonMap = jsonMap;
    }
}


