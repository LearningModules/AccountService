package com.poc.accountservice.repositories;

import com.poc.accountservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by reji on 02/06/17.
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
    List<Book> findAll();
    Book findByAuthor(String author);
}
