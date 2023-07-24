package com.example.mongopractice.service.converter;

import com.example.mongopractice.repository.model.Comment;
import com.example.mongopractice.service.model.CommentDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommentToCommentDTOConverter implements Converter<Comment, CommentDTO> {
    @Override
    public CommentDTO convert(@NotNull Comment from) {
        return new CommentDTO(from.getId(), from.getArticleId(), from.getAuthorId(), from.getContent());
    }
}

