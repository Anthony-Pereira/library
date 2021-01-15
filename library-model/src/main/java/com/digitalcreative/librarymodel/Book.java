package com.digitalcreative.librarymodel;

import lombok.Data;

@Data
public class Book {

    private Integer id;

    private Integer publication;
    private Integer unit;

    private String title;
    private String author;
    private Integer type;

}
