package com.digitalcreative.libraryservice;

import com.digitalcreative.librarymodel.Account;
import com.digitalcreative.libraryrepository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         Account account = accountRepository.getAccount(username);

         if(account==null){
             throw new UsernameNotFoundException("Utilisateur non trouvé");
         }

        return new org.springframework.security.core.userdetails.User(
                account.getEmail(),
                account.getPassword(),
                AuthorityUtils.createAuthorityList(String.valueOf(account.getRole()))

        );
    }
}
