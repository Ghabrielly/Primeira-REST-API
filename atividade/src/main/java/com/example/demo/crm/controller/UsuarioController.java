package com.example.demo.crm.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.crm.dto.Usuariodto;
import com.example.demo.crm.model.Usuario;
import com.example.demo.crm.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

	@Autowired
	private UsuarioService usuarioservice;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/criar")
	public Usuariodto criar(@RequestBody Usuario entidade) {
		return usuarioservice.criar(entidade);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping ("/id/{Id}")
	public Usuariodto buscarId(@PathVariable Long Id) {
		return usuarioservice.buscarPorId(Id);
	}
    
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Usuario> buscarTodos() {
		return usuarioservice.listar();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping ("/id/{Id}")
	public Usuario editar(@PathVariable Long Id, @RequestBody Usuario usuario) {
		return usuarioservice.editar(Id, usuario);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/id/{Id}")
	public void deletar(@PathVariable Long Id) {
		usuarioservice.deleta(Id);
	}
	
}








