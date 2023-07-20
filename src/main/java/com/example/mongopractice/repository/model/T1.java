package com.example.mongopractice.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;


@Document(collection = "T1")
@AllArgsConstructor
@Getter
@Setter
public class T1 {
    @Id
    private String id;

    @Field("array_ids")
    private String[] array_ids;
}
