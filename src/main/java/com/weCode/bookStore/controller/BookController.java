package com.weCode.bookStore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weCode.bookStore.dto.BookDTO;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    
    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooks(){
        BookDTO book = BookDTO.builder()
            .title("my first book")
            .build();
        List<BookDTO> books = new ArrayList<>();
        books.add(book);
        return ResponseEntity.ok(books);
    }
}
