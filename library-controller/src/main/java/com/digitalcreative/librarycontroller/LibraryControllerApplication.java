package com.digitalcreative.librarycontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class},scanBasePackages = {"com"})
public class LibraryControllerApplication {

    public static void main(String[] args) {SpringApplication.run(LibraryControllerApplication.class, args);
    }

}
