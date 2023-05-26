package br.com.ada.livros.mudules.clients.domain.repository;

import br.com.ada.livros.mudules.clients.domain.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository  extends JpaRepository<Livro, Long> {
}
