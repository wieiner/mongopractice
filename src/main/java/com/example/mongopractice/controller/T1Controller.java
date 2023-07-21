package com.example.mongopractice.controller;

import com.example.mongopractice.repository.model.T1;
import com.example.mongopractice.repository.model.T2;
import com.example.mongopractice.service.impl.T12ServiceImpl;
import com.example.mongopractice.service.model.T1DTO;
import com.example.mongopractice.service.model.T1WithT2sDTO;
import com.example.mongopractice.service.model.T2DTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Log4j2
public class T1Controller {

    //private final T1Repository t1Repository;
    private final T12ServiceImpl t12ServiceImpl;

    public T1Controller(T12ServiceImpl t12ServiceImpl) {
        this.t12ServiceImpl = t12ServiceImpl;
    }

    @GetMapping("/t12")
    public Flux<T1DTO> getAllT12() {
        return t12ServiceImpl.getAllT1WithT2();
    }

    @GetMapping("/t12s")
    public Flux<T1WithT2sDTO> getAllT12s() {
        return t12ServiceImpl.getAllT1WithT2s();
    }

    @GetMapping("/t1")
    public Flux<T1DTO> getAllT1() {
        return t12ServiceImpl.t1FindAll();
    }


    @GetMapping("/t2")
    public Flux<T2DTO> getAllT2() {
        return t12ServiceImpl.t2FindAll();

    }


    @PostMapping("/t2")
    public Mono<T2DTO> createT2(@RequestBody T2DTO t2DTO) {
        return t12ServiceImpl.save(t2DTO);
    }

    @PostMapping("/t1")
    public Mono<T1DTO> createT1(@RequestBody T1DTO t1DTO) {
        return t12ServiceImpl.save(t1DTO);
    }

}
