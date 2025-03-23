package com.digitalcreative.libraryservice;

import com.digitalcreative.librarymodel.Account;
import com.digitalcreative.librarymodel.EnumRole;
import com.digitalcreative.libraryrepository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Iterable<Account> getAccounts(){
        return accountRepository.getAccounts();
    }

    public Account getAccount(final int id){
        return accountRepository.getAccount(id);
    }

    public Account getAccount(final String email){
        return accountRepository.getAccount(email);
    }

    public Account createAccount(Account account) {

        account.setPassword(account.getPassword());

        Account createdAccount;

        if(account.getId() == null) {

            account.setRole(EnumRole.UTILISATEUR.getId());

            // If id is null, id is a new account.
            createdAccount = accountRepository.createAccount(account);
        } else {
            createdAccount = accountRepository.updateAccount(account);
        }
        return createdAccount;
    }

    public void deleteAccount (final int id){
        accountRepository.deleteAccount(id);
    }

}
