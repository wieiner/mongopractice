package com.example.mongopractice.repository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "T1")
public class T1 {
    @Id
    private String id;

    private List<String> array_ids;

}
