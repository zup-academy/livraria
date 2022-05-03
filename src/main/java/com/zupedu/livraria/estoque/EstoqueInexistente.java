package com.zupedu.livraria.estoque;

public class EstoqueInexistente extends RuntimeException{

    public EstoqueInexistente() {
        super("Não foi possível encontrar estoque com o identificador solicitado");
    }
}
