package com.d3lt4.projectbookstore.services;

import com.d3lt4.projectbookstore.models.Book;
import com.d3lt4.projectbookstore.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(String id, Book book) {
        bookRepository.findById(id).orElseThrow();
        return bookRepository.save(book);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public Book findBookById(String id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }
}
