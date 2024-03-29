package com.turkcell.lms.services.abstracts;

import com.turkcell.lms.entities.Loan;
import com.turkcell.lms.entities.Staff;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    List<Loan> getAll();

    Loan addLoan(Loan loan);

    void deleteLoanById(int id);

    Optional<Loan> getById(int id);

    Loan updateLoan(Loan loan);
}