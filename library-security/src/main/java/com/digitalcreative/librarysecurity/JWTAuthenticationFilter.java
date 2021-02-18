package com.digitalcreative.librarysecurity;

import com.digitalcreative.librarymodel.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        Account account = null;

        try {
            account = new ObjectMapper().readValue(request.getInputStream(),Account.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("email"+account.getEmail());
        System.out.println("password"+account.getPassword());

        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getEmail(),account.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        User springUser = (User) authResult.getPrincipal();

        String jwt = Jwts.builder()
                    .setSubject(springUser.getUsername())
                    .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS256,SecurityConstants.SECRET)
                    .claim("role",springUser.getAuthorities())
                    .compact();

        response.addHeader(SecurityConstants.HEADER_STRING,SecurityConstants.TOKEN_PREFIX+jwt);

    }

}
