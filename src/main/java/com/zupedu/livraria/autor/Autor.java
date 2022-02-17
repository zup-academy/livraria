package com.zupedu.livraria.autor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private LocalDateTime dataNascimento;

    private String biografia;

    private LocalDateTime dataCriado;

    public Autor() {
    }

    private Autor(String nome, String email, LocalDateTime nascimento, String biografia, LocalDateTime inclusao) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = nascimento;
        this.biografia = biografia;
        this.dataCriado = inclusao;
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

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public String getBiografia() {
        return biografia;
    }

    public LocalDateTime getDataCriado() {
        return dataCriado;
    }

    public static Autor buildNewAutor(String nome, String email, LocalDateTime nascimento, String biografia){
        return new Autor(nome, email, nascimento, biografia, LocalDateTime.now());
    }

    public void setId(Long id) {
        this.id = id;
    }
}
