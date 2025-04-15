package com.sadock.crosstalk.service.usuario;

import java.util.List;

import com.sadock.crosstalk.model.Usuario;
import com.sadock.crosstalk.security.CrosstalkToken;

public interface IUsuarioService {
	
	public Usuario criarNovo(Usuario novo);
	public Usuario alterarUsuario(Usuario usuario);
	public List<Usuario> listarUsuarios();
	public Usuario recuperarPeloId(Integer idUsuario);
	public Usuario recuperarPeloEmail(String emailUsuario);
	public void deletarPeloId(Integer idUsuario);
	public CrosstalkToken fazerLogin(String email, String senha);

}
