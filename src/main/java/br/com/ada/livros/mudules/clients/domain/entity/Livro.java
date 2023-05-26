package br.com.ada.livros.mudules.clients.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private Double valor;
    private Integer numPaginas;
    private String isbn;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataPubli;

    public Livro(String titulo,
                       String resumo,
                       String sumario,
                       Double valor,
                       Integer numPaginas,
                       String isbn,
                       LocalDate dataPubli) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.valor = valor;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPubli = dataPubli;
    }
}
