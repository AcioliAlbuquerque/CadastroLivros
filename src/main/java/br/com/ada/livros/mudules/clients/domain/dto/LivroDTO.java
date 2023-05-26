package br.com.ada.livros.mudules.clients.domain.dto;

import br.com.ada.livros.mudules.clients.domain.entity.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
public class LivroDTO {

    @NotNull(message = "Campo título é obrigatório!")
    private String titulo;
    @NotBlank(message = "Campo resumo é obrigatório!")
    @Size(max = 500, message = "Você ultrapassou o limite de {max} caracteres!")
    private String resumo;
    private String sumario;
    @NotNull(message = "Campo preço é obrigatório!")
    @DecimalMax(value ="20", message = "Você ultrapassou o limite de caracteres!")
    private Double valor;
    @NotNull(message = "Campo número de páginas é obrigatório!")
    @DecimalMax(value = "100", message = "Você ultrapassou o limite de caracteres!")
    private Integer numPaginas;
    @NotNull(message = "Campo isbn é obrigatório!")
    private String isbn;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataPubli;

    public Livro toLivro(){
        return new Livro(titulo, resumo, sumario, valor, numPaginas, isbn, dataPubli);
    }
}
