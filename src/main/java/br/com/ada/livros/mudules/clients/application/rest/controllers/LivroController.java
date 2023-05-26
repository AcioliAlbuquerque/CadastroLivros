package br.com.ada.livros.mudules.clients.application.rest.controllers;

import br.com.ada.livros.mudules.clients.domain.dto.LivroDTO;
import br.com.ada.livros.mudules.clients.domain.entity.Livro;
import br.com.ada.livros.mudules.clients.domain.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService service;

    @PostMapping("/criar")
    public ResponseEntity<Livro> save(@Valid @RequestBody LivroDTO livro){
        return new ResponseEntity<>(service.save(livro), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Livro> getId(@PathVariable Long id){
        return new ResponseEntity<>(service.getId(id), HttpStatus.OK);
    }
    @DeleteMapping("/excluir/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Livro> update(@RequestBody LivroDTO livro, @PathVariable Long id){
        return new ResponseEntity<>(service.update(livro, id), HttpStatus.OK);
    }

}
