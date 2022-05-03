package com.zupedu.livraria.autor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String biografia;

    private LocalDate nascimento;

    private String nacionalidade;

    private LocalDateTime criacao;

    public Autor() {
    }

    public Autor(String nome, String biografia, LocalDate nascimento, String nacionalidade) {
        this.nome = nome;
        this.biografia = biografia;
        this.nascimento = nascimento;
        this.nacionalidade = nacionalidade;
        this.criacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void atualizaDados(AutorDto dto) {
        this.biografia = dto.getBiografia();
        this.nome = dto.getNome();
        this.nacionalidade = dto.getNacionalidade();
        this.nascimento = dto.getNascimento();
    }

    public boolean existeOutroAutorComMesmosDados(AutorRepository repository){
        if(repository.findByNomeAndNacionalidadeAndNascimento(
                this.getNome(), this.getNacionalidade(), this.nascimento)
                .isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", biografia='" + biografia + '\'' +
                ", nascimento=" + nascimento +
                ", nacionalidade='" + nacionalidade + '\'' +
                '}';
    }
}
