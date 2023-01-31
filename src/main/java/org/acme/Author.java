package org.acme;

import io.quarkiverse.hibernate.types.json.JsonBinaryType;
import io.quarkiverse.hibernate.types.json.JsonTypes;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.vertx.core.json.JsonObject;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity(name="Author")
public class Author extends PanacheEntityBase {

    @Id
    @Column(length=40, unique = true)
    @GeneratedValue
    Long id;

//    @Type(type = "jsonb")
//    @Column(columnDefinition = "jsonb") // or, json
//    Book book;

    @Column(columnDefinition = "json")
    @Convert(converter = StringToJson.class)
    String jsonObject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(String jsonObject) {
        this.jsonObject = jsonObject;
    }
}


