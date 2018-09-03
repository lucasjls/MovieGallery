package com.joaolucas.moviegalerysas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;
    @JsonIgnore
    private String password;

    public Client() {
    }

    public Client(String nome, String email, String password) {
        super();
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
