package com.poc.accountservice.controller;

import com.poc.accountservice.entity.Book;
import com.poc.accountservice.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by reji on 02/06/17.
 */
@RestController
@RequestMapping(value = "/bookapi/v1")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/books")
    ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<List<Book>>(bookService.retrieveAllBooks(),HttpStatus.OK);
    }
}
