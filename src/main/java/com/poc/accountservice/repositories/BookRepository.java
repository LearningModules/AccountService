package com.poc.accountservice.repositories;

import com.poc.accountservice.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by reji on 02/06/17.
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "book", path = "book")
public interface BookRepository extends JpaRepository<Book,Integer>{

    List<Book> findAll();

    Book findByAuthor(String author);

    Book saveAndFlush(Book book);

    Book findOne(Integer bookId);



    @Modifying
    @Transactional
    @Query(value="delete from Book b where b.bookId = ?1")
    int deleteByBookId(Integer bookId);

}
