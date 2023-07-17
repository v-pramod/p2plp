package com.stackroute.p2plp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "loan")
public class Loan {
    public Loan(int i, String string) {
    }

    @Id
    private int loanId;
    private Double loanAmount;
    private Double interestRate;
    private Integer tenure;
}
