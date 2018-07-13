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
			/*
			 * session.put("usuario.id, u.id");
			 * session.put("usuario.login, u.login");
			 * session.put("usuario.senha, u.senha");
			 * 
			 * if(u.administrador != null){
				session.put("usuario.tipo", "ad");
			}
			else if(u.enfermeiro != null){
				session.put("usuario.tipo", "en");
			}
			else if(u.medico != null){
				session.put("usuario.tipo", "me");
			}
			
			session.put("usuario.administrador.id", (u.administrador != null) ? u.administrador.id : null);
			session.put("usuario.enfermeiro.id", (u.enfermeiro != null) ? u.enfermeiro.id : null);
			session.put("usuario.cozinheiro.id", (u.medico != null) ? u.medico.id : null);
		}else {
			flash.error("Usuário ou senha incorreto");
		}
			*/
			
			
			
			flash.success("Usuário logado com sucesso!");
			session.put("usuario", usuario);
			Application.inicio();
		}else {
			flash.error("E-mail ou senha inválido");
			Application.index();
		}
	}
	
	public static void logout() {	
		//flash.success("Usuário desconectado com sucesso!");
		session.clear();
		Application.index();
	}
}
