package com.zupedu.livraria.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zupedu.livraria.autor.AutorLivroResponse;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LivroResponse {

    private Long id;

    private String titulo;

    private BigDecimal valor;

    private int numeroPaginas;

    private int isbn;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataPublicacao;

    private AutorLivroResponse autor;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;

    private StatusLivro statusLivro;

    public LivroResponse(Long id, String titulo, BigDecimal valor,
                         int numeroPaginas, int isbn,
                         LocalDate dataPublicacao, AutorLivroResponse autor,
                         LocalDateTime dataCriacao, StatusLivro statusLivro) {
        this.id = id;
        this.titulo = titulo;
        this.valor = valor;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.dataCriacao = dataCriacao;
        this.statusLivro = statusLivro;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public int getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public AutorLivroResponse getAutor() {
        return autor;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public StatusLivro getStatusLivro() {
        return statusLivro;
    }

    public static LivroResponse of(Livro livro){
        var autorLivroResponse = new AutorLivroResponse(
                livro.getAutor().getId(),
                livro.getAutor().getNome());

        return new LivroResponse(livro.getId(), livro.getTitulo(), livro.getValor(),
                livro.getNumeroPaginas(), livro.getIsbn(), livro.getDataPublicacao(),
                autorLivroResponse, livro.getDataCriacao(), livro.getStatusLivro());
    }
}
