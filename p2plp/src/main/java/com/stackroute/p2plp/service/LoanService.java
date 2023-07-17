package com.stackroute.p2plp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.p2plp.model.Loan;
import com.stackroute.p2plp.repository.LoanRepository;

@Service
public class LoanService {
    
    @Autowired
    private LoanRepository loanRepository;

    public Loan getLoanById(int loanId) {
        return loanRepository.findById(loanId).get();
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan addLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public Loan updateLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public void deleteLoan(int loanId) {
        loanRepository.deleteById(loanId);
    }

}
