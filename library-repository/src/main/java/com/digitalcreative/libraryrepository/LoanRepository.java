package com.digitalcreative.libraryrepository;

import com.digitalcreative.librarymodel.Account;
import com.digitalcreative.librarymodel.Loan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LoanRepository {

    private String apiUrl = "http://localhost:9003/";

    /**
     * Get all Loans
     * @return An iterable of all accounts
     */

    public Iterable<Loan> getLoans() {

        String getLoansUrl = apiUrl + "/loans";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Loan>> response = restTemplate.exchange(
                getLoansUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Loan>>() {}
        );

        return response.getBody();
    }

    /**
     * Get a loan by the id
     * @param id The id of the loan
     * @return The loan which matches the id
     */
    public Loan getLoan(int id) {

        String getLoanUrl = apiUrl + "/loan/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Loan> response = restTemplate.exchange(
                getLoanUrl,
                HttpMethod.GET,
                null,
                Loan.class
        );

        return response.getBody();
    }

    /**
     * Add a new loan
     * @param e A new loan (without an id)
     * @return The loan full filled (with an id)
     */
    public Loan createLoan(Loan e) {

        String createLoanUrl = apiUrl + "/loan";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Loan> request = new HttpEntity<Loan>(e);
        ResponseEntity<Loan> response = restTemplate.exchange(
                createLoanUrl,
                HttpMethod.POST,
                request,
                Loan.class);

        return response.getBody();
    }

    /**
     * Update a loan - using the PUT HTTP Method.
     * @param e Existing loan to update
     */
    public Loan updateLoan(Loan e) {

        String updateLoanUrl = apiUrl + "/loan/" + e.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Loan> request = new HttpEntity<Loan>(e);
        ResponseEntity<Loan> response = restTemplate.exchange(
                updateLoanUrl,
                HttpMethod.PUT,
                request,
                Loan.class);

        return response.getBody();
    }

    /**
     * Delete a loan using exchange method of RestTemplate
     * instead of delete method in order to log the response status code.
     * @param e The loan to delete
     */
    public void deleteLoan(int id) {

        String deleteLoanUrl = apiUrl + "/loan/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteLoanUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

    }

}
