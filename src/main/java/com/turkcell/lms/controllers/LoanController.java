package com.turkcell.lms.controllers;

import com.turkcell.lms.entities.Loan;
import com.turkcell.lms.services.abstracts.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans/")
@RequiredArgsConstructor
public class LoanController {

    @Autowired
    private final LoanService loanService;

    @GetMapping()
    public List<Loan> getAll(){
        return loanService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Loan> getLoanById(@PathVariable int id){
        return loanService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteLoanById(@PathVariable int id){
        loanService.deleteLoanById(id);
    }

    @PostMapping
    public Loan addLoan(@RequestBody Loan loan){
        return loanService.addLoan(loan);
    }

    @PutMapping
    public Loan updateLoan(@RequestBody Loan loan){
        return loanService.updateLoan(loan);
    }

}