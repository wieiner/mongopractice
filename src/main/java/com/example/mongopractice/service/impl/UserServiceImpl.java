package com.example.mongopractice.service.impl;

import com.example.mongopractice.repository.T1Repository;
import com.example.mongopractice.repository.T2Repository;
import com.example.mongopractice.repository.UserRepository;
import com.example.mongopractice.repository.model.T1;
import com.example.mongopractice.repository.model.T2;
import com.example.mongopractice.repository.model.User;
import com.example.mongopractice.service.T12Service;
import com.example.mongopractice.service.UserService;
import com.example.mongopractice.service.model.T1DTO;
import com.example.mongopractice.service.model.T1WithT2sDTO;
import com.example.mongopractice.service.model.T2DTO;
import com.example.mongopractice.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConversionService conversionService;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ConversionService conversionService) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
    }


    @Override
    public Mono<UserDTO> save(UserDTO userDTO) {
        return Mono.justOrEmpty(conversionService.convert(userDTO, User.class))
                .flatMap(t1 -> userRepository.save(t1)
                        .mapNotNull(t1Fetch -> conversionService.convert(t1Fetch, UserDTO.class)));
    }

    @Override
    public Flux<UserDTO> userFindAll() {
        return userRepository
                .findAll()
                .mapNotNull(s -> conversionService.convert(s, UserDTO.class));
    }
}


