package com.pauloneto.restassuredtest;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pauloneto.restassuredtest.modelo.PerfilDTO;
import com.pauloneto.restassuredtest.modelo.UsuarioDTO;

import io.restassured.internal.http.Status;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiRestTest {

	private static final String URL_BASE = "/api-rest/api/";
	private static final String API_USUARIO = URL_BASE.concat("usuarios");
	private static final String API_PERFIL = URL_BASE.concat("perfis");
	
	@Test
	public void deveCriarUmPerfil() {
		PerfilDTO perfil = new PerfilDTO("ADMIN");
		Response post = post(API_PERFIL, perfil);
		assertTrue(Status.SUCCESS.matches(post.getStatusCode()));
	}
	
	@Test
	public void deveCriarUmUusario() {
		UsuarioDTO usuarioAcriar = new UsuarioDTO("teste","12345","teste@gmail.com");
		Response post = post(API_USUARIO, usuarioAcriar);
		assertTrue(Status.SUCCESS.matches(post.getStatusCode())); 
	}
	
	@Test
	public void deveObterTodosUsuario() {
		JsonPath json = get(API_USUARIO)
		.andReturn().jsonPath();
		UsuarioDTO usuario = json.getObject("", UsuarioDTO.class);
	}
	
	@Test
	public void deveObterTodosPerfis() {
		JsonPath json = get(API_PERFIL)
		.andReturn().jsonPath();
		PerfilDTO perfil = json.getObject("", PerfilDTO.class);
	}
}
