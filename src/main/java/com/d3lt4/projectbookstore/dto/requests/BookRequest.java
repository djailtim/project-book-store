package com.d3lt4.projectbookstore.dto.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    @NotBlank(message = "Título é obrigatório.")
    private String title;
    @NotBlank(message = "Resumo é obrigatório e deve conter no máximo 500 caracteres.")
    @Size(min = 10, max = 500, message = "Deve conter no máximo 500 caracteres.")
    private String overview;
    private String summary;
    @NotBlank(message = "Preço é obrigatório e deve ser maior que 20.")
    @Min(20)
    private BigDecimal price;
    @NotBlank(message = "Número de páginas é obrigatório e deve ser maior que 100.")
    @Min(100)
    private Integer numberPages;
    @NotBlank(message = "ISBN é obrigatório.")
    private String isbn;
    @NotBlank(message = "Data de publicação é obrigatória e precisa estar no futuro.")

    private LocalDate publisher;
}
