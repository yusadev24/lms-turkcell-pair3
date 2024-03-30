package com.turkcell.lms.services.concretes;

import com.turkcell.lms.entities.Book;
import com.turkcell.lms.repositories.BookRepository;
import com.turkcell.lms.services.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    @Autowired
    private final BookRepository bookRepository;


    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(int id) {
        if (!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Book with ID " + id + " does not exist");
        }
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> getById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book updateBook(Book book) {
        int id = book.getId();
        if (!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Book with ID " + id + " does not exist");
        }
        return bookRepository.save(book);
    }
}
