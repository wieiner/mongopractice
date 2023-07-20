package com.example.mongopractice.repository;

import com.example.mongopractice.repository.model.T1;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface T1Repository extends ReactiveMongoRepository<T1, String> , CustomT1Repository {
}
