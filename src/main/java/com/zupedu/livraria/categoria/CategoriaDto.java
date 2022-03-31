package com.zupedu.livraria.categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaDto {

    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return new Categoria(this.nome);
    }

    public Long getId() {
        return id;
    }

    public static CategoriaDto from(Categoria categoria){
        var dto = new CategoriaDto();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());

        return dto;
    }
}
