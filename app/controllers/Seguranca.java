package controllers;

import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller{
	
	@Before
    static void verificaAutenticacao() {
        if(!session.contains("usuario")) {
            flash.error("Para acessar essa funcionalidade você deve estar logado no sistema!");
            Application.index();
        }
    }
}
