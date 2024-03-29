package com.turkcell.lms.controllers;


import com.turkcell.lms.entities.Book;
import com.turkcell.lms.services.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books/")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookService bookService;

    @GetMapping()
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Book> getBookById(@PathVariable int id){
        return bookService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteBookById(@PathVariable int id){
        bookService.deleteBookById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

}
