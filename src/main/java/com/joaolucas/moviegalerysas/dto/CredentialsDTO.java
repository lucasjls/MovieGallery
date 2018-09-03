package com.joaolucas.moviegalerysas.dto;

import java.io.Serializable;

public class CredentialsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    private String password;

    public CredentialsDTO() {
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
