package com.zupedu.livraria.infra.sql;

import com.zupedu.livraria.cadastrodeautores.Autor;
import com.zupedu.livraria.cadastrodeautores.CadastraAutorRepository;
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
