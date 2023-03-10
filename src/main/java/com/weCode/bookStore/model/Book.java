package com.weCode.bookStore.model;

import java.util.UUID;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@jakarta.persistence.Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "UUID")
    private UUID id;

    @Column
    @NotNull
    private String title;
    
    @Column
    @NotNull
    private String description;
    
    @Column
    @NotNull
    private int releaseYear;
}
