package com.turkcell.lms.services.concretes;

import com.turkcell.lms.entities.Loan;
import com.turkcell.lms.repositories.LoanRepository;
import com.turkcell.lms.services.abstracts.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {
    @Autowired
    private final LoanRepository loanRepository;

    @Override
    public List<Loan> getAll() {
        return loanRepository.findAll();
    }

    @Override
    public Loan addLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public void deleteLoanById(int id) {
        if (!loanRepository.existsById(id)) {
            throw new IllegalArgumentException("Loan with ID " + id + " does not exist");
        }
        loanRepository.deleteById(id);

    }

    @Override
    public Optional<Loan> getById(int id) {
        return loanRepository.findById(id);
    }

    @Override
    public Loan updateLoan(Loan loan) {
        return loanRepository.save(loan);
    }
}