package com.example.mongopractice.repository.impl;

import com.example.mongopractice.repository.CustomT1Repository;
import com.example.mongopractice.repository.model.T1;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import reactor.core.publisher.Flux;

public class CustomT1RepositoryImpl implements CustomT1Repository {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public CustomT1RepositoryImpl(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }
    @Override
    public Flux<T1> getAllWithT2() {
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("T2")
                .localField("array_ids")
                .foreignField("ids")
                .as("array_ids");

        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);

        return reactiveMongoTemplate.aggregate(aggregation, "T1", T1.class);

    }
}
