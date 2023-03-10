package com.weCode.bookStore.repository;

import java.util.UUID;

import com.weCode.bookStore.model.Book;

import jakarta.persistence.Table;

import org.springframework.data.repository.CrudRepository;

@Table(name = "Book", schema = "PUBLIC") 
public interface BookRepository extends CrudRepository<Book,UUID>{
    
}
