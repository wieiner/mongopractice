package com.example.mongopractice.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "T2")
@AllArgsConstructor
@Getter
@Setter
public class T2 {
    @Id
    private String id;

    @Field("ids")
    private String ids;
}
