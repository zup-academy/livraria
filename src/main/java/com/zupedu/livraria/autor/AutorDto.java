package com.zupedu.livraria.autor;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class AutorDto {

    private Long id;

    @NotBlank
    private String nome;

    private String biografia;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate nascimento;

    private String nacionalidade;

    public AutorDto() {
    }

    private AutorDto(Long id, String nome, String biografia, LocalDate nascimento, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.biografia = biografia;
        this.nascimento = nascimento;
        this.nacionalidade = nacionalidade;
    }

    public static AutorDto from(Autor autor) {
        return new AutorDto(autor.getId(),
                autor.getNome(),
                autor.getBiografia(),
                autor.getNascimento(),
                autor.getNacionalidade());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Long getId() {
        return id;
    }

    public Autor toModel(){
        return new Autor(
                this.nome,
                this.biografia,
                this.nascimento,
                this.nacionalidade);
    }
}
