package com.poc.accountservice.entity.book;

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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSeries_t() {
        return series_t;
    }

    public void setSeries_t(String series_t) {
        this.series_t = series_t;
    }

    public String getSequence_i() {
        return sequence_i;
    }

    public void setSequence_i(String sequence_i) {
        this.sequence_i = sequence_i;
    }

    public String getGenre_s() {
        return genre_s;
    }

    public void setGenre_s(String genre_s) {
        this.genre_s = genre_s;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getPages_i() {
        return pages_i;
    }

    public void setPages_i(int pages_i) {
        this.pages_i = pages_i;
    }
}
