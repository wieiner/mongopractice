package com.example.mongopractice.repository;

import com.example.mongopractice.repository.model.T1;
import com.example.mongopractice.repository.model.T1WithT2s;
import reactor.core.publisher.Flux;

public interface CustomT1Repository {

Flux<T1> getAllWithT2();

 Flux<T1WithT2s> getAllWithT2s();
}
