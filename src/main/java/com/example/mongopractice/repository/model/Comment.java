package com.example.mongopractice.repository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    private String articleId;
    private String authorId;
    private String content;

    // Getters and setters...
}
