package com.digitalcreative.librarycontroller.controller;

import com.digitalcreative.libraryservice.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    AccountService accountService;

    @GetMapping("/signUp")
    String showSignUp(){
        return "signUp" ;
    }

    @PostMapping("/createAccount")
    String createAccount(){
        return "signUp" ;
    }

}
