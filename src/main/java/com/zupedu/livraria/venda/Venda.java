package com.zupedu.livraria.venda;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zupedu.livraria.livro.Livro;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Livro livro;

    private LocalDateTime compradoEm;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    private String emailCliente;

    public Venda() {
    }

    public Venda(Livro livro, BigDecimal valor, TipoPagamento tipoPagamento, String emailCliente) {
        this.livro = livro;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.compradoEm = LocalDateTime.now();
        this.emailCliente = emailCliente;
    }

    public Long getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
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

    public boolean realizaNotificacao(){
        if (this.emailCliente == null || this.emailCliente.isBlank()){
            return false;
        }
        return true;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public String getTituloNotificacao(){
        return "Aviso de compra de Livro";
    }

    public String getMensagemNotificacao() {
        return  " Você comprou o Livro "+ livro.getTitulo() +
                " , data: " + LocalDate.now()+
                " , código da compra : " + id +
                " , caso queira trocar procure a loja mais próxima com esse e-mail";
    }
}
