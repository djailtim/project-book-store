package com.d3lt4.projectbookstore.unitTesters;

import com.d3lt4.projectbookstore.dto.requests.BookRequest;
import com.d3lt4.projectbookstore.dto.responses.BookResponse;
import com.d3lt4.projectbookstore.models.Book;
import com.d3lt4.projectbookstore.repositories.BookRepository;
import com.d3lt4.projectbookstore.services.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    private ModelMapper modelMapper = new ModelMapper();

    @InjectMocks
    BookService bookServiceMock;

    @Mock
    BookRepository bookRepositoryMock;

    @Test
    @DisplayName("Should be able save a book!")
    void shouldBeAbleSaveABook() {
        BookRequest newBookRequest = new BookRequest("Any Book", "Any overview of any book.", "Any summary.", BigDecimal.valueOf(25), 110, "ABC123", LocalDate.now().plusDays(1));
        BookResponse bookResponse = bookServiceMock.addBook(newBookRequest);

        doReturn(bookResponse).when(bookRepositoryMock).save(any());
        bookResponse = bookServiceMock.addBook(newBookRequest);

        assertEquals(newBookRequest.getTitle(), bookResponse.getTitle());

    }
}
