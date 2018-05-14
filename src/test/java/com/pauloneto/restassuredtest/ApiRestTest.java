package com.pauloneto.restassuredtest;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pauloneto.restassuredtest.modelo.PerfilDTO;
import com.pauloneto.restassuredtest.modelo.UsuarioDTO;

import io.restassured.http.ContentType;
import io.restassured.internal.http.Status;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiRestTest {

	private static final String URL_BASE = "/api-rest/api/";
	private static final String API_USUARIO = URL_BASE.concat("usuarios");
	private static final String API_PERFIL = URL_BASE.concat("perfis");
	
	private PerfilDTO manager;
	private PerfilDTO programer;
	private PerfilDTO dataBaseAdmin;
	private PerfilDTO tester;
	
	private UsuarioDTO usuTeste;
	private UsuarioDTO usuProgramador;
	private UsuarioDTO usuGerente;
	private UsuarioDTO usuDBA;
	
	
	@Before
	public void before() {
		inicaPerfis();
		iniciaUsuarios();
	}
	
	@After
	public void after() {
		limpaPerfis();
		limpaUsuarios();
	}
	
	@Test
	public void deveCriarUmPerfil() {
		Response thenReturn = given().contentType(ContentType.JSON)
				.body(programer)
				.post(API_PERFIL)
				.thenReturn();
		PerfilDTO perfil = thenReturn.andReturn().jsonPath().getObject("", PerfilDTO.class);
		assertNotNull(perfil);
		System.out.println(perfil.getId());
	}
	
	
	public void deveCriarUmUsario() {
		Response thenReturn = given().contentType(ContentType.JSON)
				.body(usuProgramador)
				.post(API_USUARIO)
				.thenReturn();
		UsuarioDTO usuario = thenReturn.andReturn().jsonPath().getObject("", UsuarioDTO.class);
		assertNotNull(usuario);
		System.out.println(usuario.getId());
	}
	
	
	public void deveObterTodosUsuario() {
		JsonPath json = get(API_USUARIO)
		.andReturn().jsonPath();
		List<UsuarioDTO> usuarios = json.getList("",UsuarioDTO.class);
	}
	
	
	public void deveObterTodosPerfis() {
		JsonPath json = get(API_PERFIL)
		.andReturn().jsonPath();
		List<PerfilDTO> perfis = json.getList("",PerfilDTO.class);
	}
	
	private void iniciaUsuarios() {
		usuProgramador = new UsuarioDTO("programador","1231143", "programador@test.com");
		usuTeste = new UsuarioDTO("teste","1231143", "teste@test.com");
		usuGerente = new UsuarioDTO("gerente","1231143", "gerente@test.com");
		usuDBA = new UsuarioDTO("dba","1231143", "dba@test.com");
	}

	private void inicaPerfis() {
		manager = new PerfilDTO("MANAGER");
		programer = new PerfilDTO("PROGRAMER");
		dataBaseAdmin = new PerfilDTO("DATA-BASE-ADMIN");
		tester = new PerfilDTO("TESTER");
	}
	
	private void limpaUsuarios() {
		usuProgramador = null;
		usuTeste = null;
		usuGerente = null;
		usuDBA = null;
	}

	private void limpaPerfis() {
		manager = null;
		programer = null;
		dataBaseAdmin = null;
		tester = null;
	}
}
