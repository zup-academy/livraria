package com.zupedu.livraria.infra.sql;

import com.zupedu.livraria.cadastrodeautores.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor, Long> {
}
