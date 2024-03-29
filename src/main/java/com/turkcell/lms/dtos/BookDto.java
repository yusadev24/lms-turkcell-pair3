package com.turkcell.lms.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private int id;
    private String name;
    private String author;
    private String publisher;
    private int numberOfPages;
    //private int categoryId;
}
