package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import enums.Status;
import models.Ala;
import models.Quarto;
import play.db.jpa.JPA;
import play.mvc.Controller;

public class Alas extends Controller {

	public static void form() {
		String query = "select q from Quarto q where ala_id =" + null;
		List<Quarto> quartos = Quarto.find(query).fetch();
		render( quartos);
	}

	public static void salvar(Ala ala, List<Integer> quartosNums, List<Long> quartoIDs) {
		ala.save();
				
		// exclui quartos (exclusao lógica - não exclui o registro definitivamente do BD) 
		if(quartoIDs == null) quartoIDs = new ArrayList<Long>();
		EntityManager em = JPA.em();
		List<Long> idsQuartosDaAla = em.createQuery("select id from Quarto "
					 + "where ala_id = " + ala.id).getResultList();
		idsQuartosDaAla.removeAll(quartoIDs);
		
		for(Long id: idsQuartosDaAla) {
			Quarto quarto = Quarto.findById(id);
			quarto.status = Status.INATIVO;
			quarto.save();
		}
		
		// cria novos quartos
		if(quartosNums != null) {
			for(Integer quartoNum: quartosNums) {
				Quarto quarto = new Quarto();
				quarto.numeroQuarto = quartoNum;
				quarto.ala = ala;
				quarto.save();
				System.out.println(quarto);
			}
		}
		
		listar();
	}

	public static void editar(Long id) {
		Ala ala = Ala.findById(id);
		renderTemplate("Alas/form.html", ala);
	}


	public static void detalhes(Ala ala) {
		render(ala);
	}


	public static void listar() {
		List<Ala> alas = Ala.find("status = ?", Status.ATIVO).fetch();
		render(alas);
	}

	public static void remover(Long id) {
		Ala ala = Ala.findById(id);
		ala.status = Status.INATIVO;
		ala.save();
		listar();
	}

}