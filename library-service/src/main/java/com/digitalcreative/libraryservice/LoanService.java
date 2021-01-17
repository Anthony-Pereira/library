package com.digitalcreative.libraryservice;

import com.digitalcreative.librarymodel.Loan;
import com.digitalcreative.libraryrepository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    public Iterable<Loan> getLoans(){
        return loanRepository.getLoans();
    }

    public Loan getLoan(final int id){
        return loanRepository.getLoan(id);
    }

    public Loan createLoan(Loan loan){
        Loan createdLoan;

        if (loan.getId() == null) {
            // If id is null, id is a new loan.
            createdLoan = loanRepository.createLoan(loan);
        } else {
            createdLoan = loanRepository.updateLoan(loan);

        }
        return createdLoan;
    }

    public void deleteLoan(final  int id){
        loanRepository.deleteLoan(id);
    }

}
