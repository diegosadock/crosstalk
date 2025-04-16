package com.sadock.crosstalk.service.postagem;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sadock.crosstalk.dao.PostagemDAO;
import com.sadock.crosstalk.model.Postagem;
import com.sadock.crosstalk.model.Usuario;

@Component
public class PostagemServiceImpl implements IPostagemService {

	@Autowired
	private PostagemDAO dao;

	@Override
	public Postagem criarNova(Postagem nova) {
		nova.setDataPostagem(LocalDateTime.now());
		return dao.save(nova);
	}

	@Override
	public Postagem editarPostagem(Postagem postagem) {
		Postagem existente = dao.findById(postagem.getId())
				.orElseThrow(() -> new RuntimeException("Postagem não encontrada"));

		// Preserva a data original
		postagem.setDataPostagem(existente.getDataPostagem());
		return dao.save(postagem);
	}

	@Override
	public Postagem findById(Integer idPostagem) {
		// TODO Auto-generated method stub
		return dao.findById(idPostagem).orElse(null);
	}

	@Override
	public List<Postagem> listarPostagensPorIdUsuario(Integer id) {
		// TODO Auto-generated method stub
		return dao.findAllByUsuario_IdUsuario(id);
	}

	@Override
	public void deletar(Integer id) {
		dao.deleteById(id);

	}

	@Override
	public List<Postagem> listarTodas() {
		// TODO Auto-generated method stub
		return (List<Postagem>) dao.findAll();
	}

}
