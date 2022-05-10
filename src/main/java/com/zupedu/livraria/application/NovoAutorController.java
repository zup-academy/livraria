package com.zupedu.livraria.application;

import com.zupedu.livraria.domain.Autor;
import com.zupedu.livraria.domain.CriaNovoAutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class NovoAutorController {

    private final CriaNovoAutor service;

    public NovoAutorController(CriaNovoAutor service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cria(@RequestBody @Valid NovoAutorRequest request,
                                  UriComponentsBuilder uriBuilder) {

        Autor autor = service.cria(request);

        URI location = uriBuilder.path("/autores/{id}")
                                 .buildAndExpand(autor.getId())
                                 .toUri();

        return ResponseEntity.created(location).build();

    }
}
