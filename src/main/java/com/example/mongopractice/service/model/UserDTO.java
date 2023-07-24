package com.example.mongopractice.service.model;

import com.example.mongopractice.repository.model.User.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    @Id
    private String id;
    private String name;
    private String surname;
    private Address address;

    // Getters and setters...
}
