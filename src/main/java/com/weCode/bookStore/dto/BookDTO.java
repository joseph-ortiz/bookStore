package com.weCode.bookStore.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * 
 */
public class BookDTO {
    private UUID id;

    private String title;

    private String description;

    private int releaseYear;
}
