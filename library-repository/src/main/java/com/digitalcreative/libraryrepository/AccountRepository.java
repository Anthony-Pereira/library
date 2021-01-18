package com.digitalcreative.libraryrepository;

import com.digitalcreative.librarymodel.Account;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccountRepository {

    private String apiUrl = "http://localhost:9001/";

    /**
     * Get all accounts
     * @return An iterable of all accounts
     */

    public Iterable<Account> getAccounts() {

        String getAccountsUrl = apiUrl + "/accounts";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Account>> response = restTemplate.exchange(
                getAccountsUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Account>>() {}
        );

        return response.getBody();
    }

    /**
     * Get an account by the id
     * @param id The id of the account
     * @return The account which matches the id
     */
    public Account getAccount(int id) {

        String getAccountUrl = apiUrl + "/account/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Account> response = restTemplate.exchange(
                getAccountUrl,
                HttpMethod.GET,
                null,
                Account.class
        );

        return response.getBody();
    }

    /**
     * Add a new account
     * @param e A new account (without an id)
     * @return The account full filled (with an id)
     */
    public Account createAccount(Account e) {

        String createAccountUrl = apiUrl + "/account";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Account> request = new HttpEntity<Account>(e);
        ResponseEntity<Account> response = restTemplate.exchange(
                createAccountUrl,
                HttpMethod.POST,
                request,
                Account.class);

        return response.getBody();
    }

    /**
     * Update an account - using the PUT HTTP Method.
     * @param e Existing account to update
     */
    public Account updateAccount(Account e) {

        String updateAccountUrl = apiUrl + "/account/" + e.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Account> request = new HttpEntity<Account>(e);
        ResponseEntity<Account> response = restTemplate.exchange(
                updateAccountUrl,
                HttpMethod.PUT,
                request,
                Account.class);

        return response.getBody();
    }

    /**
     * Delete an account using exchange method of RestTemplate
     * instead of delete method in order to log the response status code.
     * @param id The account to delete
     */
    public void deleteAccount(int id) {

        String deleteAccountUrl = apiUrl + "/employee/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteAccountUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

    }

}
