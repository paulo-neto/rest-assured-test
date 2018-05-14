package com.pauloneto.restassuredtest.modelo;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class UsuarioDTO implements DTO<UsuarioDTO>{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String login;
	
	private String senha;
	
	private String email;
	
	private Set<PerfilDTO> perfis;

	public UsuarioDTO() {}
	
	public UsuarioDTO(String login, String senha, String email) {
		this.login = login;
		this.senha = senha;
		this.email = email;
	}
	
	public UsuarioDTO(String login, String senha, String email, Set<PerfilDTO> perfis) {
		this(login,senha,email);
		this.perfis = perfis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<PerfilDTO> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<PerfilDTO> perfis) {
		this.perfis = perfis;
	}
}
