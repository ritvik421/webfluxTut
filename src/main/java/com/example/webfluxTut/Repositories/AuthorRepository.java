package com.example.webfluxTut.Repositories;

import com.example.webfluxTut.Model.Author;
import com.example.webfluxTut.Model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AuthorRepository extends ReactiveMongoRepository<Author,String> {

    Flux<Author> findByNameRegex(String Regex);

    Flux<Author> findByName(String authorName);
}
