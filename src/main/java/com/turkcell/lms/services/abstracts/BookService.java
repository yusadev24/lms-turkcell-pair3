package com.turkcell.lms.services.abstracts;

import com.turkcell.lms.entities.Book;
import com.turkcell.lms.services.dtos.requests.book.AddBookRequest;
import com.turkcell.lms.services.dtos.requests.book.UpdateBookRequest;
import com.turkcell.lms.services.dtos.responses.book.AddBookResponse;
import com.turkcell.lms.services.dtos.responses.book.ListBookResponse;
import com.turkcell.lms.services.dtos.responses.book.UpdateBookResponse;
import com.turkcell.lms.services.dtos.responses.book.GetByIdBookResponse;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<ListBookResponse> getAll();

    Optional<Book> getBookEntity(int id);

    AddBookResponse addBook(AddBookRequest request);

    void deleteBookById(int id);

    Optional<GetByIdBookResponse> getById(int id);

    UpdateBookResponse updateBook(int id, UpdateBookRequest request);
    void isIdExisted(int id);
}
