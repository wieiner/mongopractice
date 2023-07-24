package com.example.mongopractice.service.converter;

import com.example.mongopractice.repository.model.Article;
import com.example.mongopractice.service.model.ArticleDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArticleDTOToArticleConverter implements Converter<ArticleDTO, Article> {
    @Override
    public Article convert(@NotNull ArticleDTO from) {
        return new Article(from.getId(), from.getTitle(), from.getAuthorId(), from.getContent(), from.getPublishDate());
    }
}

