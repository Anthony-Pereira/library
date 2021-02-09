package com.digitalcreative.librarycontroller.controller;

import com.digitalcreative.librarymodel.Loan;
import com.digitalcreative.libraryservice.LoanService;
import org.springframework.web.bind.annotation.PostMapping;

public class LoanController {

    LoanService loanService;

    @PostMapping("/createLoan")
    Loan createLoan(Loan loan){
        return loanService.createLoan(loan);
    }

}
