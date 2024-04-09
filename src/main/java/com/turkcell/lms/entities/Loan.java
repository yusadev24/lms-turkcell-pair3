package com.turkcell.lms.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_borrowed")
    private LocalDate dateBorrowed;
    @Column(name = "due_date")
    private LocalDate dueDate;
    @Column(name ="date_returned")
    private LocalDate dateReturned;
    @Column(name = "status")
    private String status;

    // *
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")

    private Member member;

}