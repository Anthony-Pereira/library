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

@Controller
public class SignInController {

    @Autowired
    AccountService accountService;

    @GetMapping("/signIn")
    public String showSignIn() {
        return "signIn";
    }

    @PostMapping("/authentication")
    public ModelAndView authentication(@ModelAttribute Account account) {

        //Authentification par email et password token aussi ??? revoir si besoin le cour de youssfi !
        accountService.getAccount(account.getEmail());

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("MySpace");

        return new ModelAndView(redirectView);
    }

}
