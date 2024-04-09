package com.turkcell.lms.services.dtos.requests.loan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLoanRequest {
    private String status;
    private LocalDate dateReturned;
}
