package com.example.webfluxTut.Repositories;

import com.example.webfluxTut.Model.Book;
import org.reactivestreams.Publisher;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book,String> {

    Flux<Book> findByGenre(String genre);

    Flux<Book> findByGenreAndCopiesAvailableGreaterThan(String genre, int copies);

    Flux<Book> findByAuthorId(String authorId);
}
