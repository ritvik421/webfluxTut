package com.example.webfluxTut.Services;

import com.example.webfluxTut.Model.Book;
import com.example.webfluxTut.Repositories.AuthorRepository;
import com.example.webfluxTut.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    @Autowired
    private BookRepository brepo ;
    @Autowired
    private AuthorRepository arepo ;

    public Flux<Book> getAllBooks(){
        return brepo.findAll() ;
    }
    public Flux<Book> getBooksByGenre(@RequestParam String genre){
        return brepo.findByGenre(genre) ;
    }
    public Flux<Book> getBooksByGenreAndCopiesAvailable(@RequestParam String genre,@RequestParam int copies){

        return brepo.findByGenreAndCopiesAvailableGreaterThan(genre, copies);
    }
    public Mono<Book> saveBook(Book book){
        return brepo.save(book) ;
    }

    public Flux<Book> getbookbyauthor(String authorName){
        return arepo
                .findByName(authorName)//Flux<Author>
                .flatMap(author -> brepo.findByAuthorId(author.getId()));
//        return brepo.findAll();
    }
}
