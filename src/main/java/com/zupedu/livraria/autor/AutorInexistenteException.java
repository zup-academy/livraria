package com.zupedu.livraria.autor;

public class AutorInexistenteException extends RuntimeException{
    public AutorInexistenteException() {
        super("Não existe uautor cadastrado com o id informado.");
    }
}
