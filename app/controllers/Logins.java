package controllers;

import models.Usuario;
import play.mvc.Controller;

public class Logins extends Controller{
		
	public static void logar(Usuario usuario){
		if (usuario.email == null || usuario.email.isEmpty()) {
			flash.error("Informe um endereço de e-mail");
		}
		
		Usuario u = Usuario.find("lower(email)", usuario.email.toLowerCase()).first();
		
		if (u == null) {
			flash.error("Voce não esta registrado no sistema");
		}
		
		if(usuario.autenticar()){
			flash.success("Usuário logado com sucesso!");
			session.put("usuario", usuario);
			Application.inicio();
		}else {
			flash.error("E-mail ou senha inválido");
			Application.index();
		}
	}
	
	public static void logout() {	
		flash.success("Usuário desconectado com sucesso!");
		session.clear();
		Application.index();
	}
}
