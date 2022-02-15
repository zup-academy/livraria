package com.zupedu.livraria.autor;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class AutorResponse {

    private Long id;

    private String nome;

    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime nascimento;

    private String biografia;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime inclusao;

    private AutorResponse(Long id, String nome, String email,
                         LocalDateTime nascimento, String biografia,
                         LocalDateTime inclusao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.biografia = biografia;
        this.inclusao = inclusao;
    }

    public static AutorResponse of(Autor autor){
        return new AutorResponse(autor.getId(), autor.getNome(),
                autor.getEmail(), autor.getDataNascimento(),
                autor.getBiografia(), autor.getCriado());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getNascimento() {
        return nascimento;
    }

    public String getBiografia() {
        return biografia;
    }

    public LocalDateTime getInclusao() {
        return inclusao;
    }
}
