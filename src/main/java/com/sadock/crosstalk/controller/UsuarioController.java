package com.sadock.crosstalk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sadock.crosstalk.model.Usuario;
import com.sadock.crosstalk.security.CrosstalkToken;
import com.sadock.crosstalk.service.usuario.IUsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		return ResponseEntity.ok(service.listarUsuarios());
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> geyById(@PathVariable Integer id) {
		Usuario result = service.recuperarPeloId(id);
		
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarNovo(@RequestBody Usuario novo) {
		Usuario result = service.criarNovo(novo);
		
		if (result != null) {
			return ResponseEntity.status(201).body(result);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) {
		usuario.setIdUsuario(id);
		Usuario result = service.alterarUsuario(usuario);
		
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<CrosstalkToken> realizarLogin(@RequestBody Usuario usuario){
		CrosstalkToken token = service.fazerLogin(usuario.getEmailUsuario(), usuario.getSenhaUsuario());
		if (token != null) {
			return ResponseEntity.ok(token);
		}
		return ResponseEntity.status(403).build();
	}
		

}
