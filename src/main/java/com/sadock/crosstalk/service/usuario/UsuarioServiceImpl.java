package com.sadock.crosstalk.service.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.sadock.crosstalk.dao.UsuarioDAO;
import com.sadock.crosstalk.model.Usuario;
import com.sadock.crosstalk.security.CrosstalkToken;
import com.sadock.crosstalk.security.TokenUtil;

@Component
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private UsuarioDAO dao;

	@Override
	public Usuario criarNovo(Usuario novo) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String novaSenha = encoder.encode(novo.getSenhaUsuario());
		
		novo.setSenhaUsuario(novaSenha);
		return dao.save(novo);
	}

	@Override
	public Usuario alterarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String novaSenha = encoder.encode(usuario.getSenhaUsuario());
		
		usuario.setSenhaUsuario(novaSenha);
		
		return dao.save(usuario);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return (List<Usuario>) dao.findAll();
	}

	@Override
	public Usuario recuperarPeloId(Integer idUsuario) {
		// TODO Auto-generated method stub
		return dao.findById(idUsuario).orElse(null);
	}

	@Override
	public void deletarPeloId(Integer idUsuario) {
		dao.deleteById(idUsuario);
	}

	@Override
	public CrosstalkToken fazerLogin(String email, String senha) {
		Usuario usuario = dao.findByEmailUsuario(email);
		
		if (usuario != null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(senha, usuario.getSenhaUsuario())) {
				return TokenUtil.encode(usuario);
			}
		}
		return null;
	}

	@Override
	public Usuario recuperarPeloEmail(String emailUsuario) {
		return dao.findByEmailUsuario(emailUsuario);
	}

}
