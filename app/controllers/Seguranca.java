package controllers;

import annotations.Admin;
import play.mvc.Before;
import play.mvc.Controller;
import controllers.Login;

public class Seguranca extends Controller{
	
	@Before
    static void verificaAutenticacao() {
		String usuario = session.get("ususario");
//		Admin admin = getControllerAnnotation(Admin.class);
		
		boolean seguranca = getControllerAnnotation(Admin.class) != null ||
				   			getActionAnnotation(Admin.class) != null;
		
		System.out.println(seguranca);
		System.out.println(usuario);
		if(seguranca && usuario == null) {
			flash.error("Por favor, entre com seu login e senha.");
            Login.login();
        }
    }
}
