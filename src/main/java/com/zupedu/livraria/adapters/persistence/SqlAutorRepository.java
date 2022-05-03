package com.zupedu.livraria.adapters.persistence;

import com.zupedu.livraria.domain.Autor;
import com.zupedu.livraria.domain.CadastraAutorRepository;
import org.springframework.stereotype.Component;

@Component
public class SqlAutorRepository implements CadastraAutorRepository {

    private final AutorRepository autorRepository;

    public SqlAutorRepository(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public Autor salva(Autor autor) {
        return autorRepository.save(autor);
    }
}
