package com.digitalcreative.librarycontroller;

import com.digitalcreative.librarysecurity.WebSecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class},scanBasePackages = {"com"})
public class LibraryControllerApplication {

    @Autowired
    WebSecurityConfiguration webSecurityConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(LibraryControllerApplication.class, args);
    }

}
