package controllers;

import java.util.List;

import com.google.gson.Gson;

import models.Ala;
import models.Enfermeiro;
import models.Internacao;
import models.Leito;
import models.Medico;
import models.Paciente;
import models.Quarto;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Internacoes extends Controller{
	
	public static void form(Long id) {
		List<Paciente> pacientes = Paciente.findAll();
		List<Medico> medicos = Medico.findAll();
		List<Enfermeiro> enfermeiros = Enfermeiro.findAll();
		String query = "select l from Leito l where quarto_id ="+ id +" and ocupado=false";
		List<Leito> leitos = Leito.find(query).fetch();
		render( pacientes, medicos, enfermeiros, leitos);
	}
	
	public static void carregarAla(){
		List<Ala> alas = Ala.findAll();
		render(alas);
	}
	
	
	public static void carregarQuarto(Long id){
		
		String query = "select q from Quarto q where ala_id =" + id;
		List<Quarto> quartos = Quarto.find(query).fetch();
		//renderText(quartos.toString());
		render(quartos);
		//System.out.println(id);
	}
	
	public static void salvar(Internacao internacao, Long pacienteID, Long medicoID, Long  enfermeiroID, Long leitoID) {
		
		
		if(pacienteID == null) {
			internacao.paciente = null;
		} else {
			Paciente paciente = Paciente.findById(pacienteID);
			internacao.paciente = paciente;
		}
		
		if(medicoID == null) {
			internacao.medico = null;
		} else {
			
			Medico medico = Medico.findById(medicoID);
			internacao.medico = medico;
		}

		if(enfermeiroID == null) {
			internacao.enfermeiro = null;
		} else {
			Enfermeiro enfermeiro = Enfermeiro.findById(enfermeiroID);
			internacao.enfermeiro = enfermeiro;
		}
		
		if(leitoID == null){
			internacao.leito = null;
		}else{
			Leito leito = Leito.findById(leitoID);
			leito.ocupado = true;
			internacao.leito = leito;
		}
	
		internacao.save();
		//flash.success("Internaçao cadastrada com sucesso!");
		//listar();
		//carregarQuarto(ala.id, internacao);
		detalhes(internacao.id);
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