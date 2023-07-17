package com.stackroute.p2plp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.p2plp.model.Loan;

@Repository
public interface LoanRepository extends MongoRepository<Loan, Integer>{
    
}
