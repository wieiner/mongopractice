package com.example.mongopractice.service;

import com.example.mongopractice.service.model.T1DTO;
import com.example.mongopractice.service.model.T1WithT2sDTO;
import com.example.mongopractice.service.model.T2DTO;
import com.example.mongopractice.service.model.UserDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserDTO> save(UserDTO userDTO);

    Flux<UserDTO> userFindAll();
}
