package com.example.mongopractice.repository;

import com.example.mongopractice.repository.model.T1;
import com.example.mongopractice.repository.model.T2;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface T1Repository extends ReactiveMongoRepository<T1, String> {
}

public interface T2Repository extends ReactiveMongoRepository<T2, String> {
}
