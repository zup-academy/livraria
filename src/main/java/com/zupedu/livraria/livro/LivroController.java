package com.zupedu.livraria.livro;

import com.zupedu.livraria.autor.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LivroResponse incluir(@RequestBody LivroRequest request){
        var livro = request.getLivro(autorRepository);

        livro = livroRepository.save(livro);

        return LivroResponse.of(livro);
    }

}
