package com.example.webfluxTut.Controller;

import com.example.webfluxTut.Model.Author;
import com.example.webfluxTut.Services.AuthorService;
import com.example.webfluxTut.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService ;
    @Autowired
    BookService bookService ;

    @PostMapping("/add")
    public Mono<Author> saveAuthor(@RequestBody  Author author){
        System.out.println("Running");
        return authorService.SaveAuthor(author) ;
    }
    @GetMapping("/authorbyname")
    public Flux<Author> getAuthorByNameRegex(@RequestParam String nameRegex){
        return authorService.getAuthorsByNameRegex(nameRegex) ;
    }


}
