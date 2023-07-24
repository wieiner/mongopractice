package com.example.mongopractice.service.converter;

import com.example.mongopractice.repository.model.ArticleWithComments;
import com.example.mongopractice.repository.model.T1WithT2s;
import com.example.mongopractice.service.model.ArticleWithCommentsDTO;
import com.example.mongopractice.service.model.T1WithT2sDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArticleWithCommentsToArticleWithCommentsDTOConverter implements Converter<ArticleWithComments, ArticleWithCommentsDTO> {
    @Override
    public ArticleWithCommentsDTO convert(@NotNull ArticleWithComments from) {
        return new ArticleWithCommentsDTO(from.getId(), from.getTitle(), from.getAuthorId(), from.getContent(),
                from.getPublishDate(), from.getComments());
    }
}

