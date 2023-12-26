package com.example.demo.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.crm.dto.Usuariodto;
import com.example.demo.crm.model.Usuario;
import com.example.demo.crm.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Usuariodto criar(Usuario entidade) {
	    Usuario usuario = usuarioRepository.save(entidade);
	    return Usuariodto.converter(usuario);
	}
	
	public Usuariodto buscarPorId (Long id) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(()	-> new RuntimeException("Pessoa não encontrada"));
		return Usuariodto.converter(usuario);
	}
	
	public Usuario editar (Long id,Usuario usuario) {
		Usuario editarUsuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada."));
		editarUsuario.setNome(usuario.getNome());
		if (usuario.getEmail() != null) {
	        editarUsuario.setEmail(usuario.getEmail());
	    } else {
	        editarUsuario.setEmail(editarUsuario.getEmail());
	    }
		return usuarioRepository.save(editarUsuario);
		
	}
	
	public List<Usuario> listar() {
		List<Usuario> usuario = usuarioRepository.findAll();
		return usuario;
	}
	
	public void deleta (Long id) {
		usuarioRepository.deleteById(id);
	}
	
	
}
