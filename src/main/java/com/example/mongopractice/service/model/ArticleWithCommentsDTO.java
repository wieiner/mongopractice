package com.example.mongopractice.service.model;

import com.example.mongopractice.repository.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ArticleWithCommentsDTO {
    private String id;
    private String title;
    private String authorId;
    private String content;
    private Date publishDate;
    List<Comment> comments;

}
