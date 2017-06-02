package com.poc.accountservice.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by reji on 02/06/17.
 */
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "bookid")
    int bookId;

   /* @OneToMany
    @JoinColumn(name = "categoryid")
    List<BookCategory>  bookCategory;*/

    @Column(name = "name")
    String name;

    @Column(name = "author")
    String author;

    @Column(name = "series_t")
    String series_t;

    @Column(name = "sequence_i")
    String sequence_i;

    @Column(name = "genre_s")
    String genre_s;

    @Column(name = "inStock")
    boolean inStock;

    @Column(name = "price")
    Float price;

    @Column(name = "pages_i")
    int pages_i;


}
