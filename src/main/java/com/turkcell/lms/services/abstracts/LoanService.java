package com.turkcell.lms.services.abstracts;

import com.turkcell.lms.entities.Book;
import com.turkcell.lms.entities.Loan;
import com.turkcell.lms.services.dtos.requests.loan.AddLoanRequest;
import com.turkcell.lms.services.dtos.requests.loan.UpdateLoanRequest;
import com.turkcell.lms.services.dtos.responses.loan.AddLoanResponse;
import com.turkcell.lms.services.dtos.responses.loan.GetByIdLoanResponse;
import com.turkcell.lms.services.dtos.responses.loan.ListLoanResponse;
import com.turkcell.lms.services.dtos.responses.loan.UpdateLoanResponse;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    List<ListLoanResponse> getAll();


    AddLoanResponse addLoan(AddLoanRequest request);

    void deleteLoanById(int id);

    Optional<GetByIdLoanResponse> getById(int id);

    UpdateLoanResponse updateLoan(int id, UpdateLoanRequest request);
}