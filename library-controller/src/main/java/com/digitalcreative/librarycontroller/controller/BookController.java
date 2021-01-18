package com.digitalcreative.librarycontroller.controller;

import com.digitalcreative.librarymodel.Book;
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

        Iterable<Book> listBooks = bookService.getBooks();

        model.addAttribute("listBooks",listBooks);

        return "books";

    }

}
