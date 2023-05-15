package com.d3lt4.projectbookstore.dto.responses;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class BookResponse {
    private String id;
    private String title;
    private String overview;
    private String summary;
    private BigDecimal price;
    private Integer numberPages;
    private String isbn;
    private LocalDate publisher;

}
