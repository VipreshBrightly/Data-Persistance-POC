package org.acme;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.IOException;
import java.util.Map;

    @Entity
    @Table(name = "Customers1")
    public class testEntity extends PanacheEntityBase {

        @Id
        private int id;

        private String firstName;

        private String lastName;

//        private String customerAttributeJSON;

        @Convert(converter = HashMapConverter.class)
        private Map<String, Object> customerAttributes;

        public int getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

//        public String getCustomerAttributeJSON() {
//            return customerAttributeJSON;
//        }

        public void setId(int id) {
            this.id = id;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
//
//        public void setCustomerAttributeJSON(String customerAttributeJSON) {
//            this.customerAttributeJSON = customerAttributeJSON;
//        }

        public void setCustomerAttributes(Map<String, Object> customerAttributes) {
            this.customerAttributes = customerAttributes;
        }

        public Map<String, Object> getCustomerAttributes() {
            return customerAttributes;
        }
    }