package com.example.mongopractice.repository;


import com.example.mongopractice.repository.model.Comment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {
}
