package com.example.mongopractice.repository;

import com.example.mongopractice.repository.model.ArticleWithComments;
import reactor.core.publisher.Flux;

public interface CustomArticleRepository {
    Flux<ArticleWithComments> getAllArticlesWithComments();
}
