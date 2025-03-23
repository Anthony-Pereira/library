package com.digitalcreative.librarycontroller;

import com.digitalcreative.librarymodel.Loan;
import com.digitalcreative.libraryservice.LoanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoanController {

    LoanService loanService;

    @PostMapping("/createLoan")
    Loan createLoan(Loan loan){
        return loanService.createLoan(loan);
    }

}
