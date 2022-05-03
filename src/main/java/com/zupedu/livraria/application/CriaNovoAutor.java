package com.zupedu.livraria.application;

import com.zupedu.livraria.domain.Autor;
import com.zupedu.livraria.domain.CadastraAutorRepository;
import com.zupedu.livraria.domain.DadosNovoAutor;
import org.springframework.stereotype.Service;

@Service
public class CriaNovoAutor {

    private final CadastraAutorRepository repository;

    public CriaNovoAutor(CadastraAutorRepository repository) {
        this.repository = repository;
    }


    public Autor cria(DadosNovoAutor novoAutor) {

        var autor = novoAutor.toModel();

        repository.salva(autor);

        return autor;
    }
}
