package com.digitalcreative.librarymodel;

import lombok.Data;

@Data
public class Account {

    private Integer id;

    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;

}
