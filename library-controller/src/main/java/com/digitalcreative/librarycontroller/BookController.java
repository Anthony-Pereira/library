package com.digitalcreative.librarycontroller;

import com.digitalcreative.libraryservice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public String showBooks(Model model){

        Iterable<com.digitalcreative.librarymodel.Book> listBooks = bookService.getBooks();

        model.addAttribute("listBooks",listBooks);

        return "books";

    }

}
