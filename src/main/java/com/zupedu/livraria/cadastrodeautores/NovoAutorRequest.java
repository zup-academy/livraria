package com.zupedu.livraria.cadastrodeautores;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.StringUtils;

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
