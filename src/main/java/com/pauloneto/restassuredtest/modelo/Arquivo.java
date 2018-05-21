package com.pauloneto.restassuredtest.modelo;

public class Arquivo{

	private Long id;
	
    private byte[] conteudo;
    
    private String tipo;
    
    private String nome;
        
	public Arquivo() {}
	
	public Arquivo(Long id, String tipo, String nome) {
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
