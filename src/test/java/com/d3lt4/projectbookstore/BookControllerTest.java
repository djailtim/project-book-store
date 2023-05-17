package com.d3lt4.projectbookstore;

import com.d3lt4.projectbookstore.controllers.BookController;
import com.d3lt4.projectbookstore.models.Book;
import com.d3lt4.projectbookstore.services.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@ExtendWith(SpringExtension.class)
//@ActiveProfiles("test")
//@WebMvcTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class BookControllerTest {

    static String BOOK_API = "/api/v1/books";

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;
    private Book book;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
        book = Book.builder()
                .id("1cf4768a-f4cd-11ed-a05b-0242ac120003")
                .title("Any Book")
                .overview("Any overview of any book.")
                .summary("Any summary.")
                .price(BigDecimal.valueOf(25))
                .numberPages(110)
                .isbn("ABC123")
                .publisher(LocalDate.now().plusDays(1))
                .build();
    }

    @Test
    @DisplayName("Should be able save a book in controller")
    public void addBook() throws Exception {

        when(bookService.addBook(any())).thenReturn(book);

        String bookJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(book);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(BOOK_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(bookJson);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").isNotEmpty())
                .andExpect(jsonPath("title").value(book.getTitle()))
                .andExpect(jsonPath("summary").value(book.getSummary()))
                .andExpect(jsonPath("overview").value(book.getOverview()));
    }

    @Test
    @DisplayName("Should not be able if invalid data for adding book")
    public void addInvalidBook() {

    }

}
