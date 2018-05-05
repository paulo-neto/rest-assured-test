package com.pauloneto.restassuredtest.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PerfilDTO implements DTO<PerfilDTO>{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String perfil;
	
	public PerfilDTO() {}
	
	public PerfilDTO(String perfil) {
		this.perfil = perfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
	
}
