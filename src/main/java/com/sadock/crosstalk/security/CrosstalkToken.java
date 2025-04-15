package com.sadock.crosstalk.security;

import com.sadock.crosstalk.model.Usuario;

public class CrosstalkToken {
	private String token;
	private Usuario usuario;

	public CrosstalkToken(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	

}
