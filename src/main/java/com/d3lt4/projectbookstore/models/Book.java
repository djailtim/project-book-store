package com.d3lt4.projectbookstore.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "tb_books")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull(message = "Título é obrigatório.")
    private String title;

    @NotNull(message = "Resumo é obrigatório e deve conter no máximo 500 caracteres.")
    @Size(min = 10, max = 500, message = "Deve conter no máximo 500 caracteres.")
    private String overview;

    private String summary;

    @NotNull(message = "Preço é obrigatório e deve ser maior que 20.")
    @Min(20)
    private BigDecimal price;

    @NotNull(message = "Número de páginas é obrigatório e deve ser maior que 100.")
    @Min(100)
    private Integer numberPages;

    @NotNull(message = "ISBN é obrigatório.")
    private String isbn;

    @NotNull(message = "Data de publicação é obrigatória e precisa estar no futuro.")
    private LocalDate publisher;
}
