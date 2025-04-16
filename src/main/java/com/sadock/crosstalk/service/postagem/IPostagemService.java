package com.sadock.crosstalk.service.postagem;

import java.util.List;

import com.sadock.crosstalk.model.Postagem;

public interface IPostagemService {
	
	public Postagem criarNova(Postagem nova);
	public Postagem editarPostagem(Postagem postagem);
	public Postagem findById(Integer idPostagem);
	public List<Postagem> listarPostagensPorIdUsuario(Integer id);
	public void deletar(Integer id);
	public List<Postagem> listarTodas();

}
