package org.serratec.backend.dto;

import org.serratec.backend.domain.Endereco;
import org.serratec.backend.domain.Usuario;

public class UsuarioResponseDTO {

	private Long id;
	private String nome;
	private String email;
	private Endereco endereco;

	public UsuarioResponseDTO() {
	}
	
	public UsuarioResponseDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.endereco = usuario.getEndereco();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
