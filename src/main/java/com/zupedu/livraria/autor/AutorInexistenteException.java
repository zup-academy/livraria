package com.zupedu.livraria.autor;

public class AutorInexistenteException extends RuntimeException{
    public AutorInexistenteException() {
        super("Não existe autor cadastrado com o id informado.");
    }
}
