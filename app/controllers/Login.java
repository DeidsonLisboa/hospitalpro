package controllers;

import models.Usuario;
import play.mvc.Controller;

public class Login extends Controller{
		
	public static void login() {
		render();
	}
	
	public static void autenticar(String email, String senha) {
		Usuario usuario = Usuario.find("email = ? and senha = ?", email, senha).first();
		if(usuario == null) {
			flash.error("Usuário ou senha inválidos.");
			params.flash();
			login();
		}else {
			session.put("usuario", usuario.email);
			Application.inicio();
		}
	}
	
	public static void logout() {	
		//flash.success("Usuário desconectado com sucesso!");
		session.clear();
		login();
	}
}
