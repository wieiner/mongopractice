package com.example.mongopractice.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "articles")
@AllArgsConstructor
@Getter
@Setter
public class Article {
    @Id
    private String id;
    @Field("title")
    private String title;
    @Field("authorId")
    private String authorId;
    @Field("content")
    private String content;
    @Field("publishDate")
    private Date publishDate;
}
