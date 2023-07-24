package com.example.mongopractice.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class ArticleDTO {

    private String id;
    private String title;
    private String authorId;
    private String content;
    private Date publishDate;

    // Getters and setters...
}
