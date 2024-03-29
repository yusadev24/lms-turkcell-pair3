package com.turkcell.lms.entities;

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

    @OneToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    @ManyToMany(mappedBy = "books")
    private List<Category> categories;
}