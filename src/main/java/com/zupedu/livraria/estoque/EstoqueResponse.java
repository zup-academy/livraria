package com.zupedu.livraria.estoque;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EstoqueResponse {

    private Long id;

    private Long idLivro;

    private int quantidade;

    private BigDecimal valorUnitario;

    private LocalDateTime atualizado;

    public EstoqueResponse() {
    }

    private EstoqueResponse(Long id, Long idLivro, int quantidade, BigDecimal valorUnitario, LocalDateTime atualizado) {
        this.id = id;
        this.idLivro = idLivro;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.atualizado = atualizado;
    }

    public static EstoqueResponse from(Estoque estoque){
        return new EstoqueResponse(estoque.getId(), estoque.getLivro().getId(),
                estoque.getQuantidade(), estoque.getValorUnitario(), estoque.getAtualizado());
    }

    public Long getId() {
        return id;
    }

    public Long getIdLivro() {
        return idLivro;
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
}
