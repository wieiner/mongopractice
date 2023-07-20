package com.example.mongopractice.service;

import com.example.mongopractice.repository.model.T1;
import com.example.mongopractice.repository.model.T2;
import reactor.core.publisher.Flux;

public interface T12Service {
    Flux<T1> getAllT1WithT2();

    Flux<T2> findAll();
}
