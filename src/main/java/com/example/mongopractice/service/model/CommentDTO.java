package com.example.mongopractice.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
@Getter
@Setter
@AllArgsConstructor
public class CommentDTO {
    @Id
    private String id;
    private String articleId;
    private String authorId;
    private String content;

    // Getters and setters...
}
