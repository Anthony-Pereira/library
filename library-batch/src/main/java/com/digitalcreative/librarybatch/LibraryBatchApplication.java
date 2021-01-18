package com.digitalcreative.librarybatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class LibraryBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryBatchApplication.class, args);
    }

}
