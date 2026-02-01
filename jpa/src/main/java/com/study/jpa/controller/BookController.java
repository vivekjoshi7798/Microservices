package com.study.jpa.controller;

import com.study.jpa.entity.Book;
import com.study.jpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping("/addBook")
    public Book AddBook(@RequestBody Book book) {
        return  bookRepository.save(book);
    }

    @GetMapping("/getBook/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

    }

    @GetMapping("/getBooks")
    public Page<Book> getBooks(Pageable pageable){
        return  bookRepository.findAll(pageable);
    }

    @GetMapping("/getBooksByGenre")
    public Page<Book> getBooksByGenre(@RequestParam String genre, Pageable pageable){
        return  bookRepository.findBooksByGenre(genre, pageable);
    }

    @GetMapping("/getBooksByTitle")
    public Page<Book> getBooksByTitle(@RequestParam String title){
        Pageable pageable = PageRequest.of(0,10, Sort.by("title").descending());
        return  bookRepository.findBooksByTitle(title, pageable);
    }

    @GetMapping("/getBooksByPrice")
    public List<Book> getBooksByPrice(){

        return  bookRepository.findAll(Sort.by("price").descending());
    }

}
