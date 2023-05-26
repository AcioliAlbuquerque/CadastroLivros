package br.com.ada.livros.integration;

import br.com.ada.livros.mudules.clients.domain.dto.LivroDTO;
import br.com.ada.livros.mudules.clients.domain.entity.Livro;
import br.com.ada.livros.mudules.clients.domain.repository.LivroRepository;
import br.com.ada.livros.mudules.clients.domain.service.LivroService;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class LivroTest1 {

    @Autowired
    private LivroService livroService;

    @Autowired
    private LivroRepository livroRepository;

    @Test
    public void testAtualizarLivroExistente() {
        Livro livroExistente = new Livro("Livro Existente", "Resumo do livro existente", null, 10.0, 200, "1234567890", LocalDate.now().plusDays(1));
        livroRepository.save(livroExistente);

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setTitulo("Novo Título");
        livroDTO.setResumo("Novo resumo");
        livroDTO.setValor(15.0);
        livroDTO.setNumPaginas(250);
        livroDTO.setIsbn("0987654321");
        livroDTO.setDataPubli(LocalDate.now().plusDays(2));

        Livro livroAtualizado = livroService.update(livroDTO, livroExistente.getId());

        assertEquals(livroExistente.getId(), livroAtualizado.getId());
        assertEquals(livroDTO.getTitulo(), livroAtualizado.getTitulo());
        assertEquals(livroDTO.getResumo(), livroAtualizado.getResumo());
        assertEquals(livroDTO.getValor(), livroAtualizado.getValor());
        assertEquals(livroDTO.getNumPaginas(), livroAtualizado.getNumPaginas());
        assertEquals(livroDTO.getIsbn(), livroAtualizado.getIsbn());
        assertEquals(livroDTO.getDataPubli(), livroAtualizado.getDataPubli());
    }
}