package com.turkcell.lms.repositories;

import com.turkcell.lms.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Integer> {
}