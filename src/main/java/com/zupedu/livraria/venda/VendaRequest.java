package com.zupedu.livraria.venda;

import com.zupedu.livraria.estoque.EstoqueRepository;
import com.zupedu.livraria.livro.LivroRepository;

import java.math.BigDecimal;

public class VendaRequest {

    private Long idLivro;

    private TipoPagamento tipoPagamento;

    public VendaRequest() {
    }

    public Venda toModel(LivroRepository livroRepository,
                         EstoqueRepository estoqueRepository){
        var livro = livroRepository.findById(this.idLivro)
                .orElseThrow(IllegalArgumentException::new);

        var estoque = estoqueRepository.findByLivro(livro)
                .orElseThrow(IllegalArgumentException::new);

        if (estoque.estaVazio()){
            throw new ImpossibilidadeVendaException();
        }

        return new Venda(livro, estoque.getValorUnitario(), this.tipoPagamento);
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
