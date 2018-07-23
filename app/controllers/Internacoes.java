package controllers;

import java.util.List;
import com.google.gson.Gson;

import annotations.Admin;
import models.Ala;
import models.Enfermeiro;
import models.Internacao;
import models.Leito;
import models.Medico;
import models.Paciente;
import models.Quarto;
import play.mvc.Controller;
import play.mvc.With;

//@Admin
@With(Seguranca.class)
public class Internacoes extends Controller{
	
	public static void form(Internacao internacao) {
		List<Paciente> pacientes = Paciente.findAll();
		List<Medico> medicos = Medico.findAll();
		List<Enfermeiro> enfermeiros = Enfermeiro.findAll();
		List<Ala> alas = Ala.findAll();
		/*String query = "select l from Leito l where quarto_id ="+ id +" and ocupado=false";
		List<Leito> leitos = Leito.find(query).fetch();*/
		render(internacao, pacientes, medicos, enfermeiros, alas);
	}
	
	/*
	public static void carregarAla(){
		List<Ala> alas = Ala.findAll();
		render(alas);
	}
	
	
	public static void carregarQuarto(Long id){
		
		String query = "select q from Quarto q where ala_id =" + id;
		List<Quarto> quartos = Quarto.find(query).fetch();		
		render(quartos);
		
	}*/
	
	public static void salvar(Internacao internacao, List<String> pacientesIDs, List<String> medicosIDs, List<String> enfermeirosIDs, List<String> alasIDs) {
	
		internacao.save();
		//flash.success("Internaçao cadastrada com sucesso!");
		listar();
		//carregarQuarto(ala.id, internacao);
		//detalhes(internacao.id);
	}
	
	public static void editar(Long id) {
		Internacao internacao = Internacao.findById(id);
		List<Paciente> pacientes = Paciente.findAll();
		List<Medico> medicos = Medico.findAll();
		List<Enfermeiro> enfermeiros = Enfermeiro.findAll();
		renderTemplate("Internacoes/form.html", internacao, pacientes, medicos, enfermeiros);
	}
	
	public static void detalhes(Long id) {
		Internacao internacao = Internacao.findById(id);
		render(internacao);
	}
	
	public static void listar() {
		List<Internacao> internacoes = Internacao.findAll();
		render(internacoes);
	}
	
	public static void remover(Long id) {
		Internacao internacao = Internacao.findById(id);
		internacao.delete();
		listar();
	}

}