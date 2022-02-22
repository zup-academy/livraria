package com.zupedu.livraria.autor;

public class AutorLivroResponse {

    private Long id;

    private String nome;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public AutorLivroResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
