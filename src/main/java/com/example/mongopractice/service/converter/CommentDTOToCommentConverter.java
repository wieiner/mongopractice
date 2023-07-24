package com.example.mongopractice.service.converter;

import com.example.mongopractice.repository.model.Article;
import com.example.mongopractice.repository.model.Comment;
import com.example.mongopractice.service.model.ArticleDTO;
import com.example.mongopractice.service.model.CommentDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommentDTOToCommentConverter implements Converter<CommentDTO, Comment> {
    @Override
    public Comment convert(@NotNull CommentDTO from) {
        return new Comment(from.getId(), from.getArticleId(),from.getAuthorId(),from.getContent());
    }
}

