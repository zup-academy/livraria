package com.zupedu.livraria.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class AutorRequest {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    private LocalDateTime dataNascimento;

    private String biografia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Autor getAutor(){
        return  Autor.build(this.nome, this.email, this.dataNascimento, this.biografia);
    }
}
