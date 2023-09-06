package com.example.webfluxTut.Services;

import com.example.webfluxTut.Model.Author;
import com.example.webfluxTut.Repositories.AuthorRepository;
import com.example.webfluxTut.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository arepo ;
    @Autowired
    private BookRepository brepo ;

    public Mono<Author> SaveAuthor(Author author){
              return arepo.save(author) ;
    }

    public Flux<Author> getAuthorsByNameRegex(String namesRegex){
        return arepo.findByNameRegex(namesRegex) ;
    }

}
