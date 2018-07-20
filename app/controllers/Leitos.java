package controllers;

import java.util.List;
import com.sun.org.apache.xpath.internal.operations.String;
import models.Leito;
import models.Medicamento;
import models.Paciente;
import play.mvc.Controller;


public class Leitos extends Controller{
	

	public static void form(Leito leito) {
		
		render(leito);
	}

	public static void salvar(Leito leito, List<String> mdcIDs) {
		/*
		String IDs = "-1";
		if(mdcIDs != null)
			IDs = String.join(", ", mdcIDs);
			
		String query = "select m from Medicamento m where m.id in " + IDs;			
		List<Medicamento> mdcs = Medicamento.find(query).fetch();
		for(Professor professor: professoresAssociados) {
			professor.departamento = departamento;
			professor.save();
		}
		
		if(mdcIDs == null || mdcIDs.isEmpty()) {
			leito.medicamentos = null;
		}else {
			String IDs = "(" + String.join(", ", mdcIDs) + ")";		
			String query = "select m from Medicamento m where m.id in " + IDs;
			List<Medicamento> mdcs = Medicamento.find(query).fetch();
			leito.medicamentos = mdcs;
		}*/
		
		leito.save();
		listar();
	}

	public static void editar(Long id) {
		Leito leito = Leito.findById(id);
		renderTemplate("Leitos/form.html", leito);
	}

	public static void detalhes(Leito leito) {
		render(leito);
	}
	
	public static void listar() {

		List<Leito> leitos = Leito.findAll();
		render(leitos);
	}

	public static void remover(Long id) {
		Leito leito = Leito.findById(id);
		leito.delete();
		listar();
	}

}