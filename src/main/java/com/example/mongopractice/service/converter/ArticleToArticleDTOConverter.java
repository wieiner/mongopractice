package com.example.mongopractice.service.converter;

import com.example.mongopractice.repository.model.Article;
import com.example.mongopractice.repository.model.T1;
import com.example.mongopractice.service.model.ArticleDTO;
import com.example.mongopractice.service.model.T1DTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArticleToArticleDTOConverter implements Converter<Article, ArticleDTO> {
    @Override
    public ArticleDTO convert(@NotNull Article from) {
        return new ArticleDTO(from.getId(), from.getTitle(), from.getAuthorId(), from.getContent(), from.getPublishDate());
    }
}

