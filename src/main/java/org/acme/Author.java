package org.acme;

import io.quarkiverse.hibernate.types.json.JsonBinaryType;
import io.quarkiverse.hibernate.types.json.JsonTypes;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Data
@Entity(name="Author")
@TypeDef(name = JsonTypes.JSON_BIN, typeClass = JsonBinaryType.class)
public class Author extends PanacheEntityBase {

    @Id
    @Column(length=40, unique = true)
    @GeneratedValue
    Long id;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb") // or, json
    Book book;

}
