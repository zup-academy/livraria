package com.zupedu.livraria.autor;

import java.time.LocalDateTime;

public class AutorResponse {

    private Long id;

    private String nome;

    private String email;

    private LocalDateTime nascimento;

    private String biografia;

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
}
