package com.zupedu.livraria.categoria;

public class CategoriaInexistenteException extends RuntimeException{

    public CategoriaInexistenteException() {
        super("Não existe categoria cadastrada com esse id");
    }
}
