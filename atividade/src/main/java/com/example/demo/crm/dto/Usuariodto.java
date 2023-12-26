package com.example.demo.crm.dto;

import com.example.demo.crm.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuariodto {
	private String nome;
	private int telefone;
	private String email;
	

	public Usuariodto(Usuario usuario) {
		this.nome = usuario.getNome();
		this.telefone = usuario.getTelefone();
		this.email = usuario.getEmail();
		}
	
	
	public static Usuariodto converter(Usuario usuario) {
	    return Usuariodto.builder()
	    	.nome(usuario.getNome())
	        .telefone(usuario.getTelefone())
	        .email(usuario.getEmail())
	        .build();
	}
}
