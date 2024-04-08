package com.turkcell.lms.controllers;


import com.turkcell.lms.entities.Book;
import com.turkcell.lms.services.abstracts.BookService;
import com.turkcell.lms.services.dtos.requests.book.AddBookRequest;
import com.turkcell.lms.services.dtos.requests.book.UpdateBookRequest;
import com.turkcell.lms.services.dtos.responses.book.*;
import com.turkcell.lms.services.dtos.responses.book.AddBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books/")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookService bookService;

    @GetMapping()
    public List<ListBookResponse> getAll(){
        return bookService.getAll();
    }

    @GetMapping("{id}")
    public Optional<GetByIdBookResponse> getBookById(@PathVariable int id){
        return bookService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteBookById(@PathVariable int id){
        bookService.deleteBookById(id);
    }

    @PostMapping
    public ResponseEntity<AddBookResponse> addBook(@RequestBody AddBookRequest request){
        AddBookResponse response = bookService.addBook(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("{id}")
    public UpdateBookResponse updateBook(@PathVariable int id, @RequestBody UpdateBookRequest request)
    {
        return bookService.updateBook(id, request);
    }

}
