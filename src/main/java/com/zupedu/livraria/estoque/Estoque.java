package com.zupedu.livraria.estoque;

import com.zupedu.livraria.livro.Livro;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Livro livro;

    private int quantidade;

    private BigDecimal valorUnitario;

    private LocalDateTime atualizado;

    public Estoque() {
    }

    public Estoque(Livro livro, int quantidade, BigDecimal valorUnitario) {
        this.livro = livro;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.atualizado = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public LocalDateTime getAtualizado() {
        return atualizado;
    }

    public void realizaBaixaEstoque(){
        this.quantidade--;
        this.atualizado = LocalDateTime.now();
    }

    public void atualizaEstoque(int quantidade, BigDecimal valorUnitario){
        this.quantidade= quantidade;
        this.valorUnitario = valorUnitario;
        this.atualizado = LocalDateTime.now();
    }

    public boolean estaVazio() {
        return this.quantidade<=0;
    }
}
