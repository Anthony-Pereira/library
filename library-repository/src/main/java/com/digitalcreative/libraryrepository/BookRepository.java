package com.digitalcreative.libraryrepository;

import com.digitalcreative.librarymodel.Book;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@Component
public class BookRepository {

        private String apiUrl = "http://localhost:9002/";

        /**
         * Get all books
         * @return An iterable of all books
         */

        public Iterable<Book> getBooks() {

            String getBooksUrl = apiUrl + "/books";

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Iterable<Book>> response = restTemplate.exchange(
                    getBooksUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Iterable<Book>>() {}
            );

            return response.getBody();
        }

    /**
     * Get a book by the id
     * @param id The id of the book
     * @return The book which matches the id
     */
    public Book getBook(int id) {

        String getBookUrl = apiUrl + "/book/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Book> response = restTemplate.exchange(
                getBookUrl,
                HttpMethod.GET,
                null,
                Book.class
        );

        return response.getBody();
    }

    /**
     * Add a new book
     * @param e A new book (without an id)
     * @return The book full filled (with an id)
     */
    public Book createBook(Book e) {

        String createBookUrl = apiUrl + "/account";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Book> request = new HttpEntity<Book>(e);
        ResponseEntity<Book> response = restTemplate.exchange(
                createBookUrl,
                HttpMethod.POST,
                request,
                Book.class);

        return response.getBody();
    }

    /**
     * Update a book - using the PUT HTTP Method.
     * @param e Existing book to update
     */
    public Book updateBook(Book e) {

        String updateBookUrl = apiUrl + "/book/" + e.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Book> request = new HttpEntity<Book>(e);
        ResponseEntity<Book> response = restTemplate.exchange(
                updateBookUrl,
                HttpMethod.PUT,
                request,
                Book.class);

        return response.getBody();
    }

    /**
     * Delete a book using exchange method of RestTemplate
     * instead of delete method in order to log the response status code.
     * @param e The book to delete
     */
    public void deleteABook(int id) {

        String deleteBookUrl = apiUrl + "/book/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteBookUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

    }

}
