package com.zupedu.livraria.application;

import com.zupedu.livraria.domain.Autor;
import com.zupedu.livraria.domain.DadosNovoAutor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record NovoAutorRequest(@NotBlank String nome,
                               @NotBlank @Email String email,
                               @NotBlank @Length(max = 400) String descricao) implements DadosNovoAutor {


    @Override
    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }

}
