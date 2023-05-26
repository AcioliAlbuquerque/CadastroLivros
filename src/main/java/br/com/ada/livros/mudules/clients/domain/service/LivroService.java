package br.com.ada.livros.mudules.clients.domain.service;

import br.com.ada.livros.mudules.clients.domain.dto.LivroDTO;
import br.com.ada.livros.mudules.clients.domain.entity.Livro;
import br.com.ada.livros.mudules.clients.domain.repository.LivroRepository;
import br.com.ada.livros.shared.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository repository;

    public Livro save(LivroDTO livroDTO){
        if (livroDTO.getDataPubli().isAfter(LocalDate.now())){
            return repository.save(livroDTO.toLivro());
        }else {
            throw new NotFoundException("Digite uma data correta.");
        }
    }

    public List<Livro> getAll(){
        return repository.findAll();
    }

    public Livro getId(Long id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("ID não encontrado."));
    }

    public void delete(Long id){
        repository.delete(getId(id));
    }

    public Livro update(LivroDTO livroDTO, Long id){
        Livro livroEntity = getId(id);
        livroEntity.setTitulo(livroDTO.getTitulo());
        livroEntity.setResumo(livroDTO.getResumo());
        livroEntity.setSumario(livroDTO.getSumario());
        livroEntity.setValor(livroDTO.getValor());
        livroEntity.setNumPaginas(livroDTO.getNumPaginas());
        livroEntity.setIsbn(livroDTO.getIsbn());
        livroEntity.setDataPubli(livroDTO.getDataPubli());
        return repository.save(livroEntity);
    }
}
