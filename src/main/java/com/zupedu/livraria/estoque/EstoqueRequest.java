package com.zupedu.livraria.estoque;

import com.zupedu.livraria.livro.LivroRepository;

import java.math.BigDecimal;

public class EstoqueRequest {

    private Long idLivro;

    private int quantidade;

    private BigDecimal valorUnitario;

    public EstoqueRequest() {
    }

    public Estoque toModel(LivroRepository livroRepository){
        var livro = livroRepository.findById(this.idLivro)
                .orElseThrow(IllegalArgumentException::new);

        return new Estoque(livro, this.quantidade, this.valorUnitario);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}



