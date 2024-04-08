package com.turkcell.lms.services.dtos.responses.book;

import com.turkcell.lms.entities.Category;
import jakarta.persistence.Column;
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
public class AddBookResponse {
    private  int id;
    private String name;
    private String author;
    private String publisher;
    private int numberOfPages;
    private List<Category> categories;
}
