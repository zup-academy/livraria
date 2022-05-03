package com.zupedu.livraria.livro;

import com.zupedu.livraria.categoria.Categoria;
import com.zupedu.livraria.autor.Autor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private LocalDate dataDeLancamento;

    private String resumo;

    private String idioma;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    private FormatoEnum formato;

    private int paginas;

    private LocalDateTime alterado;

    private LocalDateTime criacao;

    public Livro() {
    }

    public Livro(String titulo, LocalDate dataDeLancamento, String resumo,
                 String idioma, Categoria categoria, Autor autor,
                 FormatoEnum formato, int paginas) {
        this.titulo = titulo;
        this.dataDeLancamento = dataDeLancamento;
        this.resumo = resumo;
        this.idioma = idioma;
        this.categoria = categoria;
        this.autor = autor;
        this.formato = formato;
        this.paginas = paginas;
        this.alterado = LocalDateTime.now();
        this.criacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public String getResumo() {
        return resumo;
    }

    public String getIdioma() {
        return idioma;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public FormatoEnum getFormato() {
        return formato;
    }

    public int getPaginas() {
        return paginas;
    }

    public LocalDateTime getAlterado() {
        return alterado;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", dataDeLancamento=" + dataDeLancamento +
                ", resumo='" + resumo + '\'' +
                ", idioma='" + idioma + '\'' +
                ", categoria=" + categoria +
                ", autor=" + autor +
                ", formato=" + formato +
                ", paginas=" + paginas +
                ", alterado=" + alterado +
                ", criado=" + criacao +
                '}';
    }
}
