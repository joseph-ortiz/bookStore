package com.weCode.bookStore.model;

import java.util.UUID;
import org.checkerframework.checker.nullness.qual.NonNull;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "UUID")
    private UUID id;

    @Column
    @NonNull
    private String title;
    
    @Column
    @NonNull
    private String description;
    
    @Column
    @NonNull
    private int releaseYear;

    public String print(){
        return this.title + ' ' + this.description;
    }
}
