package controllers;

import java.util.List;

import models.Enfermeiro;
import models.Internacao;
import models.Medico;
import models.Paciente;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Internacoes extends Controller{
	
	public static void form(Internacao internacao) {
		List<Paciente> pacientes = Paciente.findAll();
		List<Medico> medicos = Medico.findAll();
		List<Enfermeiro> enfermeiros = Enfermeiro.findAll();
		render(internacao, pacientes, medicos, enfermeiros);
	}
	
	public static void salvar(Internacao internacao, List<String> pacientesIDs, List<String> medicosIDs, List<String> enfermeirosIDs) {
		
		
		if(pacientesIDs == null || pacientesIDs.isEmpty()) {
			internacao.pacientes = null;
		} else {
			String IDs = "(" + String.join(", ", pacientesIDs) + ")";
			String query = "select p from Paciente p where p.id in " + IDs;
			List<Paciente> pacientes = Paciente.find(query).fetch();
			internacao.pacientes = pacientes;
		}
		
		if(medicosIDs == null || medicosIDs.isEmpty()) {
			internacao.medicos = null;
		} else {
			String IDsM = "(" + String.join(", ", medicosIDs) + ")";
			String query = "select m from Medico m where m.id in " + IDsM;
			List<Medico> medicos = Medico.find(query).fetch();
			internacao.medicos = medicos;
		}

		if(enfermeirosIDs == null || enfermeirosIDs.isEmpty()) {
			internacao.enfermeiros = null;
		} else {
			String IDsE = "(" + String.join(", ", enfermeirosIDs) + ")";
			String query = "select e from Enfermeiro e where e.id in " + IDsE;
			List<Enfermeiro> enfermeiros = Enfermeiro.find(query).fetch();
			internacao.enfermeiros = enfermeiros;
		}
	
		internacao.save();
		//flash.success("Internaçao cadastrada com sucesso!");
		listar();
	}
	
	public static void editar(Long id) {
		Internacao internacao = Internacao.findById(id);
		List<Paciente> pacientes = Paciente.findAll();
		List<Medico> medicos = Medico.findAll();
		List<Enfermeiro> enfermeiros = Enfermeiro.findAll();
		renderTemplate("Internacoes/editar.html", internacao, pacientes, medicos, enfermeiros);
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