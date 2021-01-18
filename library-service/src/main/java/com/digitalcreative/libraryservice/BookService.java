package com.digitalcreative.libraryservice;

import com.digitalcreative.librarymodel.Book;
import com.digitalcreative.libraryrepository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Iterable<Book> getBooks (){
        return bookRepository.getBooks();
    }

    public Book getBook (final int id){
        return bookRepository.getBook(id);
    }

    public Book createBook(Book book) {

        Book createdBook;

        if (book.getId() == null) {
            // If id is null, id is a new book.
            createdBook = bookRepository.createBook(book);
        } else {
            createdBook = bookRepository.updateBook(book);
        }
        return createdBook;
    }

    public void deleteBook(final int id){
        bookRepository.deleteABook(id);
    }

}
