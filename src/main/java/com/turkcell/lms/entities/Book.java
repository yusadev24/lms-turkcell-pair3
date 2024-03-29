package com.turkcell.lms.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String author;
    private String publisher;
    @Column(name = "number_of_pages")
    private int numberOfPages;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    // @JsonCreator
//    public Book(@JsonProperty("name") String name,
//                @JsonProperty("author") String author,
//                @JsonProperty("publisher") String publisher,
//                @JsonProperty("numberOfPages") int numberOfPages) {
//        this.name = name;
//        this.author = author;
//        this.publisher = publisher;
//        this.numberOfPages = numberOfPages;
//    }
    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private List<Category> categories;
}