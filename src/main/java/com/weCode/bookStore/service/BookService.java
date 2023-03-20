package com.weCode.bookStore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.weCode.bookStore.dto.BookDTO;
import com.weCode.bookStore.model.Book;
import com.weCode.bookStore.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    private final ModelMapper modelmapper;

    public BookService(BookRepository bookRepository, ModelMapper modelmapper){
        this.bookRepository = bookRepository;
        this.modelmapper = modelmapper;
    }
    public List<BookDTO> getBooks(){
        Iterable<Book> all = bookRepository.findAll();
        return StreamSupport.stream(all.spliterator(),false)
                .map(convertBookModelToBookDTO())
                .collect(Collectors.toList());
    }
    private Function<? super Book, ? extends BookDTO> convertBookModelToBookDTO() {
        return book -> modelmapper.map(book,BookDTO.class);
    }
}
