package com.turkcell.lms.services.dtos.responses.book;

import com.turkcell.lms.entities.Category;
import com.turkcell.lms.services.dtos.responses.category.ListCategoryForBookResponse;
import com.turkcell.lms.services.dtos.responses.category.ListCategoryResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBookResponse {

    // TODO: category id üzerinden çağrılacak
    private int id;
    private String name;
    private String author;
    private String publisher;
    private int numberOfPages;
    private List<Category> categories;
}
