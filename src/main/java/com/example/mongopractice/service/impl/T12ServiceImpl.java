package com.example.mongopractice.service.impl;

import com.example.mongopractice.repository.T1Repository;
import com.example.mongopractice.repository.T2Repository;
import com.example.mongopractice.repository.UserRepository;
import com.example.mongopractice.repository.model.T1;
import com.example.mongopractice.repository.model.T2;
import com.example.mongopractice.repository.model.User;
import com.example.mongopractice.service.T12Service;
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
public class T12ServiceImpl implements T12Service {
    private final T1Repository t1Repository;
    private final T2Repository t2Repository;
    private final ConversionService conversionService;


    @Autowired
    public T12ServiceImpl(T1Repository t1Repository, T2Repository t2Repository, ConversionService conversionService) {
        this.t1Repository = t1Repository;
        this.t2Repository = t2Repository;
        this.conversionService = conversionService;
    }

    @Override
    public Flux<T1DTO> getAllT1WithT2() {
        return t1Repository.getAllWithT2()
                .mapNotNull(s -> conversionService.convert(s, T1DTO.class));
    }

    @Override
    public Flux<T1WithT2sDTO> getAllT1WithT2s() {
        return t1Repository.getAllWithT2s()
                .mapNotNull(s -> conversionService.convert(s, T1WithT2sDTO.class));
    }

    @Override
    public Flux<T2DTO> t2FindAll() {
        return t2Repository
                .findAll()
                .mapNotNull(s -> conversionService.convert(s, T2DTO.class));
    }

    @Override
    public Flux<T1DTO> t1FindAll() {
        return t1Repository
                .findAll()
                .mapNotNull(s -> conversionService.convert(s, T1DTO.class));
    }

    @Override
    public Mono<T2DTO> save(T2DTO t2DTO) {
        return Mono.justOrEmpty(conversionService.convert(t2DTO, T2.class))
                .flatMap(t2 -> t2Repository.save(t2)
                        .mapNotNull(t2Fetch -> conversionService.convert(t2Fetch, T2DTO.class)));
    }

    @Override
    public Mono<T1DTO> save(T1DTO t1DTO) {
        return Mono.justOrEmpty(conversionService.convert(t1DTO, T1.class))
                .flatMap(t1 -> t1Repository.save(t1)
                        .mapNotNull(t1Fetch -> conversionService.convert(t1Fetch, T1DTO.class)));
    }

}


