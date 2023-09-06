package com.example.webfluxTut.Controller;

import com.example.webfluxTut.Model.Book;
import com.example.webfluxTut.Services.AuthorService;
import com.example.webfluxTut.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    AuthorService authorService ;
    @Autowired
    BookService bookService ;

    @GetMapping("/books")

    public Flux<Book> getAllBooks(){
        return bookService.getAllBooks() ;
    }

    @GetMapping("/genre")

    public Flux<Book> getBooksByGenre(@RequestParam String genre){
        return bookService.getBooksByGenre(genre) ;
    }

    @GetMapping("/genreandcopies")

    public Flux<Book> getBooksByGenreAndCopies(@RequestParam String genre, @RequestParam int copies){

        return bookService.getBooksByGenreAndCopiesAvailable(genre,copies) ;
    }

    @PostMapping("/add")

    public Mono<Book> savebook(@RequestBody Book book){
        return bookService.saveBook(book) ;
    }

    @GetMapping("/getbookbyauthor")

    public Flux<Book> getbookbyauthor(@RequestParam String authorName){
        System.out.println("hello");
        return bookService.getbookbyauthor(authorName);
    }

}
