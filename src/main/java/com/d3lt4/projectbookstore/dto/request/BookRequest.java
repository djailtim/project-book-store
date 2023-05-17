package com.d3lt4.projectbookstore.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String title;
    private String overview;
    private String summary;
    private BigDecimal price;
    private Integer numberPages;
    private String isbn;
    private LocalDate publisher;
}
