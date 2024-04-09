package com.turkcell.lms.controllers;

import com.turkcell.lms.entities.Loan;
import com.turkcell.lms.services.abstracts.LoanService;
import com.turkcell.lms.services.dtos.requests.book.AddBookRequest;
import com.turkcell.lms.services.dtos.requests.loan.AddLoanRequest;
import com.turkcell.lms.services.dtos.requests.loan.UpdateLoanRequest;
import com.turkcell.lms.services.dtos.responses.book.AddBookResponse;
import com.turkcell.lms.services.dtos.responses.loan.AddLoanResponse;
import com.turkcell.lms.services.dtos.responses.loan.GetByIdLoanResponse;
import com.turkcell.lms.services.dtos.responses.loan.ListLoanResponse;
import com.turkcell.lms.services.dtos.responses.loan.UpdateLoanResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans/")
@RequiredArgsConstructor
public class LoanController {

    @Autowired
    private final LoanService loanService;

    @GetMapping()
    public List<ListLoanResponse> getAll(){
        return loanService.getAll();
    }

    @GetMapping("{id}")
    public Optional<GetByIdLoanResponse> getLoanById(@PathVariable int id){
        return loanService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteLoanById(@PathVariable int id){
        loanService.deleteLoanById(id);
    }

    @PostMapping
    public ResponseEntity<AddLoanResponse> addLoan(@RequestBody AddLoanRequest request){
        AddLoanResponse response = loanService.addLoan(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("{id}")
    public UpdateLoanResponse updateLoan(@PathVariable int id, @RequestBody UpdateLoanRequest request){
        return loanService.updateLoan(id,request);
    }

}