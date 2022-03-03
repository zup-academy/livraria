package com.zupedu.livraria.livro;

import com.zupedu.livraria.autor.Autor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private BigDecimal valor;

    private int numeroPaginas;

    private int isbn;

    private LocalDate dataPublicacao;

    @ManyToOne
    private Autor autor;

    private LocalDateTime dataCriacao;

    private StatusLivro statusLivro;

    public Livro() {
    }

    public Livro(String titulo, BigDecimal valor, int numeroPaginas,
                 int isbn, LocalDate dataPublicacao, Autor autor, StatusLivro statusLivro) {
        this.titulo = titulo;
        this.valor = valor;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.dataCriacao = LocalDateTime.now();
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

    public Autor getAutor() {
        return autor;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public StatusLivro getStatusLivro() {
        return statusLivro;
    }
}
