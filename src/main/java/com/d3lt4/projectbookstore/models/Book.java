package com.d3lt4.projectbookstore.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_books")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String overview;
    private String summary;
    private BigDecimal price;
    private Integer numberPages;
    private String isbn;
    private LocalDate publisher;
}
