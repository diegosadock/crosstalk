package com.sadock.crosstalk.dto;

import com.sadock.crosstalk.model.Usuario;

public class LoginResponse {
    private String token;
    private Usuario usuario;

    public LoginResponse(String token, Usuario usuario) {
        this.token = token;
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
