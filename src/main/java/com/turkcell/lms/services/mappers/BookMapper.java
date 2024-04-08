package com.turkcell.lms.services.mappers;

import com.turkcell.lms.entities.Book;
import com.turkcell.lms.services.dtos.requests.book.AddBookRequest;
import com.turkcell.lms.services.dtos.responses.book.GetByIdBookResponse;
import com.turkcell.lms.services.dtos.responses.book.ListBookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {

      BookMapper INSTANCE= Mappers.getMapper(BookMapper.class);
       @Mapping(source = "categoryIds", target = "categories", ignore = true)
      Book bookFromAddBookRequest(AddBookRequest request);


    List<ListBookResponse> booksToListBookResponses(List<Book> books);

    GetByIdBookResponse mapToGetByIdBookResponse(Book book);
}
