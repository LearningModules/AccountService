package com.poc.accountservice.repositories;

import com.poc.accountservice.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by reji on 02/06/17.
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "book", path = "book")
public interface BookRepository extends JpaRepository<Book,Long>{
    List<Book> findAll();
    Book findByAuthor(String author);
}
