package com.stackroute.p2plp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.p2plp.model.Loan;
import com.stackroute.p2plp.service.LoanService;

@RestController
@RequestMapping("/api/v1/")
public class LoanController {

    @Autowired
    private LoanService loanService;
    ResponseEntity<?> responseEntity;

    // @PreAuthorize("hasRole('ROLE_LENDER','ROLE_ADMIN','ROLE_BORROWER')")
    @GetMapping("/loan/{loanId}")
    public ResponseEntity<?> getLoanById(int loanId) {
        return ResponseEntity.ok(loanService.getLoanById(loanId));
    }

    @GetMapping("/loan")
    // @PreAuthorize("hasAuthority('LENDER')")
    public ResponseEntity<?> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @PostMapping("/loan")
    // @PreAuthorize("hasAuthority('ADMIN','BORROWER')")
    public ResponseEntity<?> addLoan(@RequestBody Loan loan) {
        return ResponseEntity.ok(loanService.addLoan(loan));
    }

    // @PreAuthorize("hasRole('ROLE_ADMIN','ROLE_BORROWER')")
    @PutMapping("/loan/{loanId}")
    public ResponseEntity<?> updateLoan(@RequestBody Loan loan, @PathVariable int loanId) {
        loan.setLoanId(loanId);
        return ResponseEntity.ok(loanService.updateLoan(loan));
    }

    // @PreAuthorize("hasRole( 'ROLE_ADMIN','ROLE_BORROWER')")
    @DeleteMapping("/loan/{loanId}")
    public ResponseEntity<?> deleteLoan(@PathVariable int loanId) {
        loanService.deleteLoan(loanId);
        return ResponseEntity.ok("Loan deleted successfully");
    }
}
