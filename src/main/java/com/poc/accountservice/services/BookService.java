package com.poc.accountservice.services;

import com.poc.accountservice.entity.book.Book;
import com.poc.accountservice.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by reji on 02/06/17.
 */
@Component
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> retrieveAllBooks()
    {
        System.out.println("books retrieved ="+bookRepository.findAll().size());
        return  bookRepository.findAll();
    }

    public Book saveBook(Book book)
    {
        System.out.println("Book added "+book.getAuthor());
        return  bookRepository.saveAndFlush(book);
    }

    public Book getBookDetails(Integer bookId)
    {
        System.out.println("Getting for book ID "+bookId);
        return  bookRepository.findOne(bookId);
    }

    public int deleteBook(Integer bookId)
    {
        System.out.println("Deleting Book ID -"+bookId);
        return bookRepository.deleteByBookId(bookId);
    }
}
