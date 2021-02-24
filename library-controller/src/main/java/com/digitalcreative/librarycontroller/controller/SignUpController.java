package com.digitalcreative.librarycontroller.controller;

import com.digitalcreative.librarymodel.Account;
import com.digitalcreative.libraryservice.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SignUpController {

    @Autowired
    AccountService accountService;

    @GetMapping("/signUp")
    ModelAndView showSignUp(){

        String view = "signUp";
        Map<String,Object> model = new HashMap<String,Object>();

        model.put("account",new Account());

        return new ModelAndView(view,model);
    }

    @PostMapping("/createAccount")
    ModelAndView createAccount(@ModelAttribute Account account){

        System.out.println("Account = " + account);

        accountService.createAccount(account);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/signIn");

        return new ModelAndView(redirectView) ;
    }

}
