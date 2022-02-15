package com.zupedu.livraria.autor;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class AutorRequest {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
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
        return  Autor.buildNewAutor(this.nome,
                this.email, this.dataNascimento, this.biografia);
    }
}
