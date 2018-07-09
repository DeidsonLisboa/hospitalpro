package controllers;

import models.Usuario;
import play.mvc.Controller;

public class Usuarios extends Controller{
	
	public static Usuario getUsuariobyusuario(Usuario usuario){
		
		Usuario u = Usuario.find("usuario.id = ?", usuario.id).first();
		return u;
	}
}
