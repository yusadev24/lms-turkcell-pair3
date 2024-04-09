package com.turkcell.lms.services.dtos.responses.loan;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddLoanResponse {
    private int id;
    private int bookId;
    private int memberId;
    private LocalDate dateBorrowed;
    private LocalDate dueDate;
    private LocalDate dateReturned;
    private String status;
}
