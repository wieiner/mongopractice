package com.example.mongopractice.service;

import com.example.mongopractice.service.model.ArticleDTO;
import com.example.mongopractice.service.model.ArticleWithCommentsDTO;
import com.example.mongopractice.service.model.CommentDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ArticlesCommentedService {

    Mono<ArticleDTO> save(ArticleDTO articleDTO);

    Flux<ArticleDTO> articleFindAll();

    Mono<CommentDTO> save(CommentDTO CommentDTO);

    Flux<CommentDTO> commentFindAll();

    Flux<ArticleWithCommentsDTO> artcomFindAll();
}
