package com.weCode.bookStore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.weCode.bookStore.dto.BookDTO;
import com.weCode.bookStore.model.Book;
import com.weCode.bookStore.repository.BookRepository;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;
    
    @Mock
    private BookRepository bookRepository;

    @Mock
    private ModelMapper mapper;

    @Test
    void shouldReturnListofBooksDtoWhenGetBooksCalled(){
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = getBook();
        books.add(book);
        when(bookRepository.findAll()).thenReturn(books);
        BookDTO bookDto = getBookDto();
        when(mapper.map(book,BookDTO.class)).thenReturn(bookDto);
        List<BookDTO> bookDtos = bookService.getBooks();
        assertThat(1).isEqualTo(bookDtos.size());
        assertThat(bookDtos.get(0))
            .isNotNull()
            .hasFieldOrPropertyWithValue("title", "test title")
            .hasFieldOrPropertyWithValue("description", "test description")
            .hasFieldOrPropertyWithValue("releaseYear", 2023);
    }

    private Book getBook(){
        return Book.builder()
            .title("test title")
            .description("test description")
            .id(UUID.randomUUID())
            .releaseYear(2023)
            .build();
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
