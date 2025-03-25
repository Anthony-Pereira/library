package com.digitalcreative.librarycontroller;

import com.digitalcreative.librarymodel.Account;
import com.digitalcreative.libraryservice.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    AccountService accountService;

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("account", new Account());
        return "register"; // Renvoie la vue "register.html"
    }


    @PostMapping("/createAccount")
    public String createAccount(@ModelAttribute Account account, Model model) {

        try {

            // Validation dans le service
            accountService.validatePasswords(account.getPassword(), account.getConfirmPassword());

            // Si la validation est correcte, procédez à l'enregistrement
            accountService.createAccount(account);

            return "redirect:/login"; // Redirection après succès
        } catch (IllegalArgumentException e) {
            // Retourner au formulaire en cas d'erreur
            model.addAttribute("errorMessage", e.getMessage());
            return "register";
        }
    }
}
