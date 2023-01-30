package org.acme;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.IOException;
import java.util.Map;

    @Entity
    @Table(name = "Customers")
    public class testEntity {

        @Id
        private int id;

        private String firstName;

        private String lastName;

        private String customerAttributeJSON;

        @Convert(converter = HashMapConverter.class)
        private Map<String, Object> customerAttributes;

    }