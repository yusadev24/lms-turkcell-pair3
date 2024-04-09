package com.turkcell.lms.services.concretes;

import com.turkcell.lms.core.utils.exceptions.types.BusinessException;
import com.turkcell.lms.entities.Book;
import com.turkcell.lms.entities.Category;
import com.turkcell.lms.repositories.BookRepository;
import com.turkcell.lms.services.abstracts.BookService;
import com.turkcell.lms.services.abstracts.CategoryService;
import com.turkcell.lms.services.dtos.requests.book.AddBookRequest;
import com.turkcell.lms.services.dtos.requests.book.UpdateBookRequest;
import com.turkcell.lms.services.dtos.responses.book.AddBookResponse;
import com.turkcell.lms.services.dtos.responses.book.GetByIdBookResponse;
import com.turkcell.lms.services.dtos.responses.book.ListBookResponse;
import com.turkcell.lms.services.dtos.responses.book.UpdateBookResponse;
import com.turkcell.lms.services.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    @Override
    public List<ListBookResponse> getAll() {
        List<Book> books = bookRepository.findAll();
        return BookMapper.INSTANCE.booksToListBookResponses(books);
    }

    @Override
    public Optional<Book> getBookEntity(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public AddBookResponse addBook(AddBookRequest request) {
        List<Category> categories = categoryService.getAllCategoryEntities(request.getCategoryIds());
        Book book = BookMapper.INSTANCE.bookFromAddBookRequest(request);
        book.setCategories(categories);
        /*Book book = Book.builder()
                .name(request.getName())
                .author(request.getAuthor())
                .publisher(request.getPublisher())
                .numberOfPages(request.getNumberOfPages())
                .categories(categories)
                .build();*/
        Book savedBook = bookRepository.save(book);

        return new AddBookResponse(
                savedBook.getId(),
                savedBook.getName(),
                savedBook.getAuthor(),
                savedBook.getPublisher(),
                savedBook.getNumberOfPages(),
                savedBook.getCategories());
    }

    @Override
    public void deleteBookById(int id) {
        isIdExisted(id);
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<GetByIdBookResponse> getById(int id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        isIdExisted(id);

        return bookOptional.map(BookMapper.INSTANCE::mapToGetByIdBookResponse);
    }

    @Override
    public UpdateBookResponse updateBook(int id, UpdateBookRequest request) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        isIdExisted(id);
        UpdateBookResponse response = new UpdateBookResponse();

        bookOptional.ifPresent(book -> {
            if (request.getCategoryIds() != null && !request.getCategoryIds().isEmpty()) {
                List<Category> categories = new ArrayList<>();
                for (Integer categoryId : request.getCategoryIds()) {
                    Optional<Category> categoryOptional = categoryService.findEntityById(categoryId);
                    categoryOptional.ifPresent(categories::add);
                }
                book.setCategories(categories);
            }

            try {
                Book savedBook = bookRepository.save(book);

                System.out.println("Updated Book: " + savedBook);

                // Populate response with updated book details
                response.setId(savedBook.getId());
                response.setName(savedBook.getName());
                response.setAuthor(savedBook.getAuthor());
                response.setPublisher(savedBook.getPublisher());
                response.setCategories(savedBook.getCategories());
                response.setNumberOfPages(savedBook.getNumberOfPages());
            } catch (Exception ex) {
                ex.printStackTrace();
                // Log any exceptions that occur during the update process
                System.err.println("Error updating book: " + ex.getMessage());
            }
        });

        return response;
    }

    public   void isIdExisted(int id){
        if (!bookRepository.existsById(id)) {
            throw new BusinessException("Book with ID " + id + " does not exist");
        }
    }

}
