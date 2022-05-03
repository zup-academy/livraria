package com.zupedu.livraria.venda;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VendaResponse {

    private Long id;

    private Long idLivro;

    private LocalDateTime compradoEm;

    private BigDecimal valor;

    private TipoPagamento tipoPagamento;

    public VendaResponse() {
    }

    private VendaResponse(Long id, Long idLivro,
                         LocalDateTime compradoEm, BigDecimal valor,
                         TipoPagamento tipoPagamento) {
        this.id = id;
        this.idLivro = idLivro;
        this.compradoEm = compradoEm;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
    }

    public static VendaResponse from(Venda venda){
        return new VendaResponse(venda.getId(), venda.getLivro().getId(),
                venda.getCompradoEm(),
                venda.getValor(), venda.getTipoPagamento());
    }

    public Long getId() {
        return id;
    }

    public Long getIdLivro() {
        return idLivro;
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
