package com.digitalcreative.libraryrepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class},scanBasePackages = {"com"})
public class LibraryRepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryRepositoryApplication.class, args);
    }

}
