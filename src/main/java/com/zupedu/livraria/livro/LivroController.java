package com.zupedu.livraria.livro;

import com.zupedu.livraria.autor.AutorRepository;
import com.zupedu.livraria.categoria.CategoriaController;
import com.zupedu.livraria.categoria.CategoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/livros")
public class LivroController {

    Logger logger = LoggerFactory.getLogger(LivroController.class);

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

        logger.info("Livro incluído com sucesso : {} ", livro);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(LivroDto.from(livro));
    }

    @GetMapping
    public ResponseEntity<?> lista(){
        var livros = livroRepository.findAll();
        var livrosResponse = new ArrayList<LivroDto>();

        for (var livro:livros ) {
            livrosResponse.add(LivroDto.from(livro));
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(livrosResponse);
    }
}
