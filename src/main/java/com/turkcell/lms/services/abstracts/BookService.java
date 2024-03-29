package com.turkcell.lms.services.abstracts;

import com.turkcell.lms.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAll();

    Book addBook(Book book);

    void deleteBookById(int id);

    Optional<Book> getById(int id);

    Book updateBook(Book book);
}
