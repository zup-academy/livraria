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

    public Livro() {
    }
}
