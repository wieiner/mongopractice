package com.example.mongopractice.repository.impl;

import com.example.mongopractice.repository.CustomArticleRepository;
import com.example.mongopractice.repository.model.ArticleWithComments;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import reactor.core.publisher.Flux;

public class CustomArticleRepositoryImpl implements CustomArticleRepository {
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public CustomArticleRepositoryImpl(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Override
    public Flux<ArticleWithComments> getAllArticlesWithComments() {
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("comments")
                .localField("_id")
                .foreignField("articleId")
                .as("comments");

        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);

        return reactiveMongoTemplate.aggregate(aggregation, "articles", ArticleWithComments.class);

    }

}
