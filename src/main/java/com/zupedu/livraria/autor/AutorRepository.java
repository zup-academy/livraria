package com.zupedu.livraria.autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNomeAndNacionalidadeAndNascimento(
            String nome, String nacionalidade, LocalDate nascimento);

}
