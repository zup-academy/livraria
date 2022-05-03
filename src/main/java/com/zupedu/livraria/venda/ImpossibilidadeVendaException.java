package com.zupedu.livraria.venda;

public class ImpossibilidadeVendaException extends RuntimeException{

    public ImpossibilidadeVendaException() {
        super("Não foi possível concluir a venda, verifique o estoque do produto");
    }
}
