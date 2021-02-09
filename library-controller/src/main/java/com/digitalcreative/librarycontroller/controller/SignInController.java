package com.digitalcreative.librarycontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInController {

    @GetMapping("/signIn")
    public String showSignIn(){
        return "signIn";
    }

    @PostMapping("/signIn")
    public String authentification(){
        return "signIn";
    }

}
