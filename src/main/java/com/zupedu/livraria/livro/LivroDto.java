package com.zupedu.livraria.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zupedu.livraria.autor.Autor;
import com.zupedu.livraria.categoria.Categoria;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LivroDto {

    private Long id;

    @NotBlank
    private String titulo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDeLancamento;

    private String resumo;

    private String idioma;

    private Long idCategoria;

    private Long idAutor;

    private FormatoEnum formato;

    private int paginas;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime alterado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public FormatoEnum getFormato() {
        return formato;
    }

    public void setFormato(FormatoEnum formato) {
        this.formato = formato;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public LocalDateTime getAlterado() {
        return alterado;
    }

    public void setAlterado(LocalDateTime alterado) {
        this.alterado = alterado;
    }
}
