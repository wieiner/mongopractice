package com.example.mongopractice.repository;


import com.example.mongopractice.repository.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
