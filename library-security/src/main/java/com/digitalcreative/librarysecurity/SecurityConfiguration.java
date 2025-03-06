package com.digitalcreative.librarysecurity;

import lombok.var;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(auth -> auth
                        .anyRequest().authenticated() // Tous les endpoints nécessitent une authentification
                )
                .formLogin(form -> form // Utilise un formulaire de connexion par défaut fourni par Spring Security
                        .permitAll()
                )
                .httpBasic(); // Active aussi l'authentification Basic (optionnel)

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Utilisation de l'encodage BCrypt pour sécuriser les mots de passe
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        var user = User.withUsername("user")
                .password(encoder.encode("password")) // Le mot de passe est encodé
                .roles("USER") // Rôle associé à l'utilisateur
                .build();

        var admin = User.withUsername("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

}
