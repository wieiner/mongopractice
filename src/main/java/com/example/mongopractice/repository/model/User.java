package com.example.mongopractice.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "users")
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("surname")
    private String surname;
    @Field("address")
    private Address address;

    // Getters and setters...

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Address {
        @Field("phone")
        private String phone;
        @Field("email")
        private String email;
        @Field("homeAddress")
        private HomeAddress homeAddress;


        @AllArgsConstructor
        @Getter
        @Setter
        public static class HomeAddress {
            @Field("city")
            private String city;
            @Field("street")
            private String street;
            @Field("building")
            private String building;

        }
    }
}
