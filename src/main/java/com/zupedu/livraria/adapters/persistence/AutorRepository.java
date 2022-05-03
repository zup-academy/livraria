package com.zupedu.livraria.adapters.persistence;

import com.zupedu.livraria.domain.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor, Long> {
}
