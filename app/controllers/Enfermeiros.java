package controllers;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import annotations.Admin;
import models.Enfermeiro;
import models.Usuario;
import play.Play;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@Admin
@With(Seguranca.class)
public class Enfermeiros extends Controller {
	
	public static void form() {
		List<String> sexos = Arrays.asList(new String[]{"Masculino", "Feminino", "Outros",});
		List<String> estados = Arrays.asList(new String[]{"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RS", "RN", "RO", "RR", "SC", "SP", "SE", "TO"});
		List<String> nacionalidades = Arrays.asList(new String[]{"Brasileiro(a)"});
		List<String> estadosCivis = Arrays.asList(new String[]{"Solteiro(a)", "Casado(a)", "Divociado(a)", "Viúvo(a)", "Outro"});
		render(sexos, estados, nacionalidades, estadosCivis);
	}
	
	public static void salvar(@Valid Enfermeiro enfermeiro) {
		System.out.println(params.get("excluirFoto"));
		if(params.get("excluirFoto") != null) {
			enfermeiro.foto.getFile().delete();
		}
		
		System.out.println(validation.hasErrors());
		
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			form();
		}
				
		enfermeiro.save();
		flash.success("Enfermeiro cadastrado com sucesso!");
		listar();
	}
	
	public static void editar(Long id) {
		Enfermeiro enfermeiro = Enfermeiro.findById(id);
		List<String> sexos = Arrays.asList(new String[]{"Masculino", "Feminino", "Outros",});
		List<String> estados = Arrays.asList(new String[]{"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RS", "RN", "RO", "RR", "SC", "SP", "SE", "TO"});
		List<String> nacionalidades = Arrays.asList(new String[]{"Brasileiro(a)", "Estrangeiro(a)"});
		List<String> estadosCivis = Arrays.asList(new String[]{"Solteiro(a)", "Casado(a)", "Divociado(a)", "Viúvo(a)", "Outro"});
		renderTemplate("Enfermeiros/form.html", enfermeiro, sexos, estados, nacionalidades, estadosCivis);
	}
	
	public static void detalhes(Long id) {
		Enfermeiro enfermeiro = Enfermeiro.findById(id);
		render(enfermeiro);
	}
	
	
	public static void listar() {
		List<Enfermeiro> enfermeiros = Enfermeiro.findAll();
		render(enfermeiros);
	}
	
	public static void remover(Long id) {
		Enfermeiro enfermeiro = Enfermeiro.findById(id);
		enfermeiro.delete();
		flash.success("Enfermeiro removido com sucesso!");
		listar();
	}
	
	public static void fotoEnfermeiro(Long id) {
		Enfermeiro enfermeiro = Enfermeiro.findById(id);
	    notFoundIfNull(enfermeiro);
	    response.setContentTypeIfNotSet(enfermeiro.foto.type());
	    renderBinary(enfermeiro.foto.get());
	    
	}
	
	
	public static void fotoPadrao(){
		File file = Play.getFile("/public/images/perfilenfermeira.jpg");
		renderBinary(file);
		
	}
	
}