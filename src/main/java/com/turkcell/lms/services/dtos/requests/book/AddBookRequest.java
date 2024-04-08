package com.turkcell.lms.services.dtos.requests.book;

import com.turkcell.lms.entities.Category;
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
public class AddBookRequest{
    private String name;
    private String author;
    private String publisher;
    private int numberOfPages;
    private List<Integer> categoryIds;
}
