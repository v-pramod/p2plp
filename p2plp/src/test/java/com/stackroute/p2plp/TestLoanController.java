package com.stackroute.p2plp;

import com.stackroute.p2plp.controller.LoanController;
import com.stackroute.p2plp.model.Loan;
import com.stackroute.p2plp.service.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

class TestLoanController {
    @Mock
    private LoanService loanService;

    @InjectMocks
    private LoanController loanController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetLoanById() {
        // Arrange
        int loanId = 1;
        Loan loan = new Loan(loanId, "Loan 1");

        when(loanService.getLoanById(loanId)).thenReturn(loan);

        // Act
        ResponseEntity<?> response = loanController.getLoanById(loanId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(loan, response.getBody());
        verify(loanService, times(1)).getLoanById(loanId);
    }

    @Test
    void testGetAllLoans() {
        // Arrange
        Loan loan1 = new Loan(1, "Loan 1");
        Loan loan2 = new Loan(2, "Loan 2");

        when(loanService.getAllLoans()).thenReturn(List.of(loan1, loan2));

        // Act
        ResponseEntity<?> response = loanController.getAllLoans();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(loan1, loan2), response.getBody());
        verify(loanService, times(1)).getAllLoans();
    }

    @Test
    void testAddLoan() {
        // Arrange
        Loan loan = new Loan();

        when(loanService.addLoan(loan)).thenReturn(loan);

        // Act
        ResponseEntity<?> response = loanController.addLoan(loan);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(loan, response.getBody());
        verify(loanService, times(1)).addLoan(loan);
    }

    @Test
    void testUpdateLoan() {
        // Arrange
        int loanId = 1;
        Loan loan = new Loan(loanId, "Loan 1");

        when(loanService.updateLoan(loan)).thenReturn(loan);

        // Act
        ResponseEntity<?> response = loanController.updateLoan(loan, loanId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(loan, response.getBody());
        verify(loanService, times(1)).updateLoan(loan);
    }

    @Test
    void testDeleteLoan() {
        // Arrange
        int loanId = 1;

        // Act
        ResponseEntity<?> response = loanController.deleteLoan(loanId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Loan deleted successfully", response.getBody());
        verify(loanService, times(1)).deleteLoan(loanId);
    }
}
