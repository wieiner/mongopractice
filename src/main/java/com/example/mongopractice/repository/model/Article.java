package com.example.mongopractice.repository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "articles")
public class Article {
    @Id
    private String id;
    private String title;
    private String authorId;
    private String content;
    private Date publishDate;

    // Getters and setters...
}
