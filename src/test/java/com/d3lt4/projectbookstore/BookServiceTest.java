package com.d3lt4.projectbookstore;

import com.d3lt4.projectbookstore.models.Book;
import com.d3lt4.projectbookstore.repositories.BookRepository;
import com.d3lt4.projectbookstore.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepositoryMock;

    @Autowired
    @InjectMocks
    private BookService bookServiceMock;

    private Book book1;
    private Book book2;
    private List<Book> bookList;

    @BeforeEach
    public void setUp() {
        book1 = Book.builder()
                .id("1cf4768a-f4cd-11ed-a05b-0242ac120003")
                .title("Any Book")
                .overview("Any overview of any book.")
                .summary("Any summary.")
                .price(BigDecimal.valueOf(25))
                .numberPages(110)
                .isbn("ABC123")
                .publisher(LocalDate.now().plusDays(1))
                .build();

        book2 = Book.builder()
                .id("1cf4768a-f4cd-11ed-a05b-0242ac120004")
                .title("Any Book 2")
                .overview("Any overview of any book 2.")
                .summary("Any summary.")
                .price(BigDecimal.valueOf(35))
                .numberPages(130)
                .isbn("ABC123")
                .publisher(LocalDate.now().plusDays(1))
                .build();

        bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

    }

    @Test
    @DisplayName("Should be able save a book!")
    void shouldBeAbleSaveABook() {
        Book book = Book.builder()
                .title("Any Book")
                .overview("Any overview of any book.")
                .summary("Any summary.")
                .price(BigDecimal.valueOf(25))
                .numberPages(110)
                .isbn("ABC123")
                .publisher(LocalDate.now().plusDays(1))
                .build();

        when(bookRepositoryMock.save(any())).thenReturn(book1);
        Book bookSaved = bookServiceMock.addBook(book);
        assertEquals(bookSaved.getId(), book1.getId());
        assertEquals(bookSaved.getTitle(), book1.getTitle());
    }

    @Test
    @DisplayName("Should be able update a book")
    void shouldBeAbleUpdateABook() {
        when(bookRepositoryMock.findById("1cf4768a-f4cd-11ed-a05b-0242ac120003")).thenReturn(Optional.of(book1));
        when(bookRepositoryMock.save(any())).thenReturn(book1);
        book1.setTitle("Book Updated");
        Book bookUpdated = bookServiceMock.updateBook("1cf4768a-f4cd-11ed-a05b-0242ac120003", book1);

        assertEquals(bookUpdated.getTitle(), "Book Updated");
    }

    @Test
    @DisplayName("Shoul be able delete a book")
    void shouldBeAbleDeleteABook() {
        doNothing().when(bookRepositoryMock).deleteById("1cf4768a-f4cd-11ed-a05b-0242ac120003");
        bookServiceMock.deleteBook("1cf4768a-f4cd-11ed-a05b-0242ac120003");
    }

    @Test
    @DisplayName("Shoul be able return a book when searching with id")
    void shouldBeAbleReturnABook() {
        when(bookRepositoryMock.findById("1cf4768a-f4cd-11ed-a05b-0242ac120003")).thenReturn(Optional.of(book1));
        Book bookFound = bookServiceMock.findBookById("1cf4768a-f4cd-11ed-a05b-0242ac120003");

        assertEquals(bookFound.getTitle(), book1.getTitle());
    }

    @Test
    @DisplayName("Shoul be able return a list of all books")
    void shouldBeAbleReturnAListAllBooks() {
        when(bookRepositoryMock.findAll()).thenReturn(bookList);
        List<Book> books = bookServiceMock.listAllBooks();

        assertFalse(books.isEmpty());
        assertEquals(2, books.size());
        assertEquals(books.get(0).getTitle(), book1.getTitle());
        assertEquals(books.get(1).getTitle(), book2.getTitle());
    }
}
