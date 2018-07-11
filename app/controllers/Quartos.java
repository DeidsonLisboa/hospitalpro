package controllers;

import java.util.List;
import models.Leito;
import models.Quarto;
import play.mvc.Controller;

public class Quartos extends Controller{
	
	public static void form() {
		List<Leito> leitos = Leito.findAll();
		render(leitos);
	}
	
	public static void salvar(Quarto quarto, List<String> leitosIDs) {
		quarto.save();
		String IDs = "-1";
		if(leitosIDs != null)
			IDs = String.join(", ", leitosIDs);
			
		String query = "select l from Leito l where l.id in (" + IDs + ")";			
		List<Leito> leitosAssociados = Leito.find(query).fetch();
		
		for(Leito leito: leitosAssociados) {
			leito.quarto = quarto;
			leito.save();
		}
		
		query = "select l from Leito l where l.id not in ("+ IDs + ")";	
		System.out.println(query);
		List<Leito> leitosNaoAssociados = Leito.find(query).fetch();
		for(Leito leito: leitosNaoAssociados) {
			if(leito.quarto != null && 
			  leito.quarto.id == quarto.id) {
				leito.quarto = null;
				leito.save();
			}
		}
		quarto.save();
		flash.success("quarto salvo com sucesso!");
		detalhes(quarto);
		//listar();
	}

	public static void editar(Long id) {
		Quarto quarto = Leito.findById(id);
		renderTemplate("Quartos/form.html", quarto);
	}

	public static void detalhes(Quarto quarto) {
		render(quarto);
	}

	public static void listar() {
		List<Quarto> quartos = Quarto.findAll();
		render(quartos);
	}

	public static void remover(Long id) {
		Quarto quarto = Quarto.findById(id);
		quarto.delete();
		listar();
	}
}