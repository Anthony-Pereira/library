package com.digitalcreative.librarysecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class},scanBasePackages = {"com"})
public class LibrarySecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrarySecurityApplication.class, args);
    }

}
