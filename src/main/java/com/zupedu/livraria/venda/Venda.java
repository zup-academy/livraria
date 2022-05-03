package com.zupedu.livraria.venda;

import com.zupedu.livraria.livro.Livro;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Livro livro;

    private LocalDateTime compradoEm;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    public Venda() {
    }

    public Venda(Livro livro, BigDecimal valor, TipoPagamento tipoPagamento) {
        this.livro = livro;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.compradoEm = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDateTime getCompradoEm() {
        return compradoEm;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }
}
