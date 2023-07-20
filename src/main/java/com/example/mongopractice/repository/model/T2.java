package com.example.mongopractice.repository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "T2")
public class T2 {
    @Id
    private String id;

}
