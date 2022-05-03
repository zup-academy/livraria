package com.zupedu.livraria.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.StringJoiner;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String descricao;

    /**
     * @deprecated para uso dos frameworks
     */
    @Deprecated
    public Autor() { }

    public Autor(String nome, String email, String descricao) {

        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Autor.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .add("email='" + email + "'")
                .add("descricao='" + descricao + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return email.equals(autor.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
