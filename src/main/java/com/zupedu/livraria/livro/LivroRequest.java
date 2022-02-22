package com.zupedu.livraria.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zupedu.livraria.autor.AutorInexistenteException;
import com.zupedu.livraria.autor.AutorRepository;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    private String titulo;

    private BigDecimal valor;

    private int numeroPaginas;

    private int isbn;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataPublicacao;

    private long idAutor;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public void setIdAutor(long idAutor) {
        this.idAutor = idAutor;
    }

    public Livro getLivro(AutorRepository autorRepository) {
        var autor= autorRepository.findById(this.idAutor)
                .orElseThrow(AutorInexistenteException::new);

        return new Livro(this.titulo, this.valor, this.numeroPaginas,
                this.isbn, this.dataPublicacao, autor);
    }
}
