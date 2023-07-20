package com.example.mongopractice.controller;
import com.example.mongopractice.repository.T1Repository;
import com.example.mongopractice.repository.model.T1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class T1Controller {

    private final T1Repository t1Repository;

    public T1Controller(T1Repository t1Repository) {
        this.t1Repository = t1Repository;
    }

    @GetMapping("/t1")
    public Flux<T1> getAllT1() {
        return t1Repository.findAll();
    }
}
