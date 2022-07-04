package com.zupedu.livraria.notificacao;

public class Notificacao {

    private String destinatario;

    private String tipo;

    private String titulo;

    private String message;

    public Notificacao(String destinatario, String tipo, String titulo, String message) {
        this.destinatario = destinatario;
        this.tipo = tipo;
        this.titulo = titulo;
        this.message = message;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMessage() {
        return message;
    }
}
