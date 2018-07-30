package controllers;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import annotations.Admin;
import models.Enfermeiro;
import models.Medico;
import play.Play;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@Admin
@With(Seguranca.class)
public class Medicos extends Controller{
	
	public static void form() {
		List<String> sexos = Arrays.asList(new String[]{"Masculino", "Feminino", "Outros",});
		List<String> estados = Arrays.asList(new String[]{"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RS", "RN", "RO", "RR", "SC", "SP", "SE", "TO"});
		List<String> nacionalidades = Arrays.asList(new String[]{"Brasileiro(a)"});
		List<String> estadosCivis = Arrays.asList(new String[]{"Solteiro(a)", "Casado(a)", "Divociado(a)", "Viúvo(a)", "Outro"});
		render(sexos, estados, nacionalidades, estadosCivis);
	}
	
	public static void salvar(@Valid Medico medico) {
		System.out.println(params.get("excluirFoto"));
		if(params.get("excluirFoto") != null) {
			medico.foto.getFile().delete();
		}
		System.out.println(validation.hasErrors());
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			form();
		}
		
		medico.save();
		flash.success("Médico cadastrado com sucesso!");
		listar();
	}
	
	public static void editar(Long id) {
		Medico medico = Medico.findById(id);
		List<String> sexos = Arrays.asList(new String[]{"Masculino", "Feminino", "Outros",});
		List<String> estados = Arrays.asList(new String[]{"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RS", "RN", "RO", "RR", "SC", "SP", "SE", "TO"});
		List<String> nacionalidades = Arrays.asList(new String[]{"Brasileiro(a)", "Estrangeiro(a)"});
		List<String> estadosCivis = Arrays.asList(new String[]{"Solteiro(a)", "Casado(a)", "Divociado(a)", "Viúvo(a)", "Outro"});
		renderTemplate("Medicos/form.html", medico, sexos, estados, nacionalidades, estadosCivis);
	}
	
	public static void detalhes(Long id) {
		Medico medico = Medico.findById(id);
		render(medico);
	}
	
	public static void listar() {
		List<Medico> medicos = Medico.findAll();
		render(medicos);
	}
	
	public static void remover(Long id) {
		Medico medico = Medico.findById(id);
		medico.delete();
		flash.success("Médico removido com sucesso!");
		listar();
	}
	
	public static void fotoMedico(Long id) {
		Medico medico = Medico.findById(id);
	    notFoundIfNull(medico);
	    response.setContentTypeIfNotSet(medico.foto.type());
	    renderBinary(medico.foto.get());
	}
	
	public static void fotoPadrao(){
		File file = Play.getFile("/public/images/perfilmedico.jpg");
		renderBinary(file);
		
	}
}