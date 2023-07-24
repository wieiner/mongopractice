package com.example.mongopractice.controller;

import com.example.mongopractice.repository.model.ArticleWithComments;
import com.example.mongopractice.service.impl.ArticlesCommentedServiceImpl;
import com.example.mongopractice.service.impl.T12ServiceImpl;
import com.example.mongopractice.service.impl.UserServiceImpl;
import com.example.mongopractice.service.model.*;
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

    private final T12ServiceImpl t12ServiceImpl;
    private final ArticlesCommentedServiceImpl articlesCommentedService;
    private final UserServiceImpl userService;

    public T1Controller(T12ServiceImpl t12ServiceImpl, ArticlesCommentedServiceImpl articlesCommentedService, UserServiceImpl userService) {
        this.t12ServiceImpl = t12ServiceImpl;
        this.articlesCommentedService = articlesCommentedService;
        this.userService = userService;
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


    /*--------------------------------------------------------*/
//                  User Controller

    @GetMapping("/user")
    public Flux<UserDTO> getAllUsers() {
        return userService.userFindAll();

    }

    /* json for testing purposes
    {
        "name" : "Ivanov",
        "surname" : "Sergey",

        "address" : {
        "phone": "333-22-333",
        "email": "SIvanov@gmail.com",
        "homeAddress":
        {
        "city" :   "Minsk",
        "street":  "ul.Traktornaya",
        "building": "10"
        }

        }
    }

     */
    @PostMapping("/user")
    public Mono<UserDTO> createUser(@RequestBody UserDTO userDTO) {

        return userService.save(userDTO);
    }

    /*--------------------------------------------------------*/
//                  Article/Comments Controller


    @GetMapping("/artcom")
    public Flux<ArticleWithCommentsDTO> getAllArtCom() {
        return articlesCommentedService.artcomFindAll();
    }


    @GetMapping("/article")
    public Flux<ArticleDTO> getAllArticles() {
        return articlesCommentedService.articleFindAll();
    }


    /* json example
    {
    "id" : "884",
    "title" : "Dead mouse found near Utrecht..",
    "authorId" : "14",
    "content" : "Dead mouse found near Utrecht..blablabla blablabla blablabla blablabla blablabla",
    "publishDate" : "2023-07-24"
    }
     */

    @PostMapping("/article")
    public Mono<ArticleDTO> createArticle(@RequestBody ArticleDTO articleDTO) {

        return articlesCommentedService.save(articleDTO);
    }


    @GetMapping("/comment")
    public Flux<CommentDTO> getAllComments() {
        return articlesCommentedService.commentFindAll();
    }


    /* json example
    {
    "id" : "1",
    "articleId" : "884",
    "authorId" : "14",
    "content" : "blah blah bad suxx, bed bed bed. heil satan"
    }
     */

    @PostMapping("/comment")
    public Mono<CommentDTO> createComment(@RequestBody CommentDTO commentDTO) {

        return articlesCommentedService.save(commentDTO);
    }



}
