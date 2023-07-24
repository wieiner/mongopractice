package com.example.mongopractice.service;

import com.example.mongopractice.service.model.T1DTO;
import com.example.mongopractice.service.model.T1WithT2sDTO;
import com.example.mongopractice.service.model.T2DTO;
import com.example.mongopractice.service.model.UserDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface T12Service {
    Flux<T1DTO> getAllT1WithT2();
    Flux<T1WithT2sDTO> getAllT1WithT2s();

    Flux<T2DTO> t2FindAll();
    Flux<T1DTO> t1FindAll();

    Mono<T2DTO> save(T2DTO t2DTO);
    Mono<T1DTO> save(T1DTO t1DTO);

    Mono<UserDTO> save(UserDTO userDTO);

    Flux<UserDTO> userFindAll();
}
