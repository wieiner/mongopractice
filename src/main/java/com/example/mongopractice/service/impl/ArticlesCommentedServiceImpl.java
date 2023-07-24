package com.example.mongopractice.service.impl;

import com.example.mongopractice.repository.ArticleRepository;
import com.example.mongopractice.repository.CommentRepository;
import com.example.mongopractice.repository.model.Article;
import com.example.mongopractice.repository.model.Comment;
import com.example.mongopractice.service.ArticlesCommentedService;
import com.example.mongopractice.service.model.ArticleDTO;
import com.example.mongopractice.service.model.ArticleWithCommentsDTO;
import com.example.mongopractice.service.model.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ArticlesCommentedServiceImpl implements ArticlesCommentedService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final ConversionService conversionService;

    @Autowired
    public ArticlesCommentedServiceImpl(ArticleRepository articleRepository, CommentRepository commentRepository, ConversionService conversionService) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
        this.conversionService = conversionService;
    }

    @Override
    public Mono<ArticleDTO> save(ArticleDTO articleDTO) {
        return Mono.justOrEmpty(conversionService.convert(articleDTO, Article.class))
                .flatMap(ar -> articleRepository.save(ar)
                        .mapNotNull(arFetch -> conversionService.convert(arFetch, ArticleDTO.class)));

    }

    @Override
    public Flux<ArticleDTO> articleFindAll() {
        return articleRepository
                .findAll()
                .mapNotNull(s -> conversionService.convert(s, ArticleDTO.class));
    }

    @Override
    public Mono<CommentDTO> save(CommentDTO CommentDTO) {
        return Mono.justOrEmpty(conversionService.convert(CommentDTO, Comment.class))
                .flatMap(ar -> commentRepository.save(ar)
                        .mapNotNull(cmFetch -> conversionService.convert(cmFetch, CommentDTO.class)));

    }

    @Override
    public Flux<CommentDTO> commentFindAll() {
        return commentRepository
                .findAll()
                .mapNotNull(s -> conversionService.convert(s, CommentDTO.class));
    }

    @Override
    public Flux<ArticleWithCommentsDTO> artcomFindAll() {
        return articleRepository.getAllArticlesWithComments()
                .mapNotNull(s -> conversionService.convert(s, ArticleWithCommentsDTO.class));
    }
}
