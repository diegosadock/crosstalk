package com.sadock.crosstalk.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sadock.crosstalk.model.Postagem;
import com.sadock.crosstalk.model.Usuario;

public interface PostagemDAO extends CrudRepository<Postagem, Integer> {
	
	public List<Postagem> findAllByUsuario_IdUsuario(Integer idUsuario);


}
