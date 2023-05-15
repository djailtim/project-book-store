package com.d3lt4.projectbookstore.services;

import com.d3lt4.projectbookstore.dto.requests.BookRequest;
import com.d3lt4.projectbookstore.dto.responses.BookResponse;
import com.d3lt4.projectbookstore.models.Book;
import com.d3lt4.projectbookstore.repositories.BookRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse addBook(@Valid BookRequest bookRequest) {
        Book book = modelMapper.map(bookRequest, Book.class);
        Book bookSaved = bookRepository.save(book);
        return modelMapper.map(bookSaved, BookResponse.class);
    }
}
