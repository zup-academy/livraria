package com.zupedu.livraria.livro;

import com.zupedu.livraria.autor.AutorRepository;
import com.zupedu.livraria.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<?> inserir(@Valid @RequestBody LivroDto dto){

        var livro = dto.toModel(autorRepository, categoriaRepository);

        livro = livroRepository.save(livro);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(LivroDto.from(livro));
    }
}
