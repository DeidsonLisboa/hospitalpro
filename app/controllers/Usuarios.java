package controllers;

import java.util.List;

import annotations.Admin;
import enums.Status;
import models.Usuario;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

//@Admin
@With(Seguranca.class)
public class Usuarios extends Controller{
	

		public static void form() {
			Status[] status = Status.values();
			int a = 1;
			render(a, status);
		}
		
		public static void listar() {
			List<Usuario> usuarios = Usuario.findAll();
			render(usuarios);
		}
		
		public static void salvar(@Valid Usuario usuario) {
			if(validation.hasErrors()) {
				validation.keep();
				params.flash();
				form();
			}
			usuario.save();
			flash.success("Usuário salvo com sucesso!");
			listar();
		}
		
		public static void editar(Long id) {
			Usuario usuario = Usuario.findById(id);
			Status[] status = Status.values();
			renderTemplate("Usuarios/form.html", usuario, status);
		}
		
		public static void remover(Long id) {
			Usuario usuario = Usuario.findById(id);
			usuario.delete();
			flash.success("Usuário removido com sucesso!");
			listar();
		}
}
