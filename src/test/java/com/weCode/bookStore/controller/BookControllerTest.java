package com.weCode.bookStore.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.weCode.bookStore.dto.BookDTO;
import com.weCode.bookStore.service.BookService;
import static org.mockito.Mockito.description;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.experimental.ExtensionMethod;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Test
    void shouldReturnBookDtoListWhenGetBooksCalled(){
        List<BookDTO> bookDtos = new ArrayList<BookDTO>();
        bookDtos.add(getBookDto());
        when(bookService.getBooks()).thenReturn(bookDtos);
        ResponseEntity<List<BookDTO>> books = bookController.getBooks();
        assertThat(books.getBody()).isNotNull();
        assertThat(books.getBody().size()).isEqualTo(1);
    }

    private BookDTO getBookDto(){
        return BookDTO.builder()
            .title("test title")
            .description("test description")
            .id(UUID.randomUUID())
            .releaseYear(2023)
            .build();
    }
    
}
