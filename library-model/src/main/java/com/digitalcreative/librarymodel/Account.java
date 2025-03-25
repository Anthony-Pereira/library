package com.digitalcreative.librarymodel;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class Account {

    private Integer id;

    private String name;
    private String surname;
    private String email;
    @NotBlank(message = "le mot de passe est obligatoire")
    private String password;
    @NotBlank(message = "La confirmation du mot de passe est obligatoire")
    private String confirmPassword;
    private String phone;

    private Integer role;

}
