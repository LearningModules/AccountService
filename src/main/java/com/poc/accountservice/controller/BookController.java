package com.poc.accountservice.controller;

import com.poc.accountservice.entity.book.Book;
import com.poc.accountservice.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Refer - https://www.leveluplunch.com/java/tutorials/014-post-json-to-spring-rest-webservice/
 */
@RestController
@Component
@RequestMapping(value = "/bookapi/v1")
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<List<Book>>(bookService.retrieveAllBooks(),HttpStatus.OK);
    }

    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    public ResponseEntity createABook(@RequestBody Book book){
        return new ResponseEntity<Book>(bookService.saveBook(book),HttpStatus.OK);
    }
}
