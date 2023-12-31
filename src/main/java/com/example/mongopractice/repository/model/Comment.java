package com.example.mongopractice.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "comments")
@AllArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    private String id;
    @Field("articleId")
    private String articleId;
    @Field("authorId")
    private String authorId;
    @Field("content")
    private String content;
}
