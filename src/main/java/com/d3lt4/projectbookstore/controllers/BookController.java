package com.d3lt4.projectbookstore.controllers;

import com.d3lt4.projectbookstore.dto.requests.BookRequest;
import com.d3lt4.projectbookstore.dto.responses.BookResponse;
import com.d3lt4.projectbookstore.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest bookRequest) {
        BookResponse bookResponse = bookService.addBook(bookRequest);
        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
    }
}
