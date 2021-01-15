package com.digitalcreative.librarymodel;

import lombok.Data;

@Data
public class Loan {

    private Integer id;

    private Integer userId;
    private Integer bookId;

    private String borrowingDate;
    private String returnDate;

    private Boolean prolongation;

}
