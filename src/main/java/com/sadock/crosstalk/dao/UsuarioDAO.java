package com.sadock.crosstalk.dao;

import org.springframework.data.repository.CrudRepository;

import com.sadock.crosstalk.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	
	public Usuario findByEmailUsuario(String emailUsuario);

}
