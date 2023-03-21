package com.weCode.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weCode.bookStore.dto.BookDTO;
import com.weCode.bookStore.service.BookService;

/* import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse; */


//@Api(value= "Book Api", tags = "Book Api", produces = "application/json")
@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;
    /*
    @ApiOperation(value="get list of books", response = BookDTO[].class, produces = "application/json")
     @ApiResponses( value = {
        @ApiResponse(code = 200, message = "Succssefully retrieved list of book"),
        @ApiResponse(code = 304, message = "Accessing the resource you were trying to reach is"),
        @ApiResponse(code = 404, message = "Not found resource")
    }) */ 
    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooks(){
        List<BookDTO> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }
}
