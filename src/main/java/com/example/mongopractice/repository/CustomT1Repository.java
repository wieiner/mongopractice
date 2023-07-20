package com.example.mongopractice.repository;

import com.example.mongopractice.repository.model.T1;
import reactor.core.publisher.Flux;

public interface CustomT1Repository {

Flux<T1> getAllWithT2();

}
