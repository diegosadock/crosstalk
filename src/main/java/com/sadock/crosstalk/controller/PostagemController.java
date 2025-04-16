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

import com.sadock.crosstalk.model.Postagem;
import com.sadock.crosstalk.model.Usuario;
import com.sadock.crosstalk.service.postagem.IPostagemService;
import com.sadock.crosstalk.service.usuario.IUsuarioService;

@RestController
public class PostagemController {
	
	@Autowired
	private IPostagemService service;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/postagens")
	public ResponseEntity<List<Postagem>> recuperarTodas() {
		return ResponseEntity.ok(service.listarTodas());
	}
	
	@PostMapping("/postagens")
	public ResponseEntity<Postagem> criarNova(@RequestBody Postagem nova) {
		Postagem result = service.criarNova(nova);
		
		if (result != null) {
			return ResponseEntity.status(201).body(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/postagens/{id}")
	public ResponseEntity<Postagem> editarPostagem(@RequestBody Postagem postagem, @PathVariable Integer id) {
		postagem.setId(id);
		
		Postagem result = service.editarPostagem(postagem);
		
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/postagens/usuario/{id}") 
	public ResponseEntity<List<Postagem>> listarPostagemPeloIdDoUsuario(@PathVariable Integer id) {
		List<Postagem> result = service.listarPostagensPorIdUsuario(id);
		
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}

}
