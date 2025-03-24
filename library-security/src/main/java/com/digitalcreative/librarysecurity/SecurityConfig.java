package com.digitalcreative.librarysecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/public/**", "/register").permitAll() // "/public/**" et "/register" accessibles à tous
                        .anyRequest().authenticated() // Toutes les autres routes nécessitent une authentification
                )
                .formLogin((form) -> form
                        .loginPage("/login") // Spécifie une page de login personnalisée
                        .permitAll() // Permet l'accès à cette page sans authentification
                )
                .logout((logout) -> logout.permitAll()); // Permet de déconnexion pour tous
        return http.build();
    }

    // Bean pour encoder les mots de passe
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Utilise BCrypt pour encoder les mots de passe
    }
}