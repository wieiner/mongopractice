package com.example.mongopractice.repository;


import com.example.mongopractice.repository.model.Article;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ArticleRepository extends ReactiveMongoRepository<Article, String>, CustomArticleRepository {
}
