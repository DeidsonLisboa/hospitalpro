package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import annotations.Admin;
import enums.Status;
import models.Leito;
import models.Quarto;
import play.db.jpa.JPA;
import play.mvc.Controller;
import play.mvc.With;

@Admin
@With(Seguranca.class)
public class Quartos extends Controller{
	
	public static void form() {
		List<Quarto> quartos = Quarto.findAll();
		String query = "select l from Leito l where quarto_id =" + null;
		List<Leito> leitos = Leito.find(query).fetch();
		//List<Leito> leitos = Leito.findAll();
		render(quartos, leitos);
	}
	
	public static void salvar(Quarto quarto, Long quartoid, List<Integer> leitosNums, List<Long> leitoIDs) {
		
		
		quarto.save();
		quarto.delete();
		
		Quarto quartoQ = Quarto.findById(quartoid);
		
		// exclui leitos (exclusao lógica - não exclui o registro definitivamente do BD) 
		if(leitoIDs == null) leitoIDs = new ArrayList<Long>();
		EntityManager em = JPA.em();
		List<Long> idsLeitosDoQuarto = em.createQuery("select id from Leito "
					 + "where quarto_id = " + quartoid).getResultList();
		idsLeitosDoQuarto.removeAll(leitoIDs);
		
		for(Long id: idsLeitosDoQuarto) {
			Leito leito = Leito.findById(id);
			leito.statusleito = Status.INATIVO;
			leito.save();
		}
		
		// cria novos leitos
		if(leitosNums != null) {
			for(Integer leitoNum: leitosNums) {
				Leito leito = new Leito();
				leito.numeroLeito = leitoNum;
				leito.quarto = quartoQ;
				leito.save();
				System.out.println(leito);
			}
		}
		
		//listar();
		
		detalhes(quartoQ.id);
		
	}

	public static void editar(Long id) {
		Quarto quarto = Leito.findById(id);
		renderTemplate("Quartos/form.html", quarto);
	}

	public static void detalhes(Long id) {
		Quarto quarto = Quarto.findById(id);
		render(quarto);
	}

	public static void listar() {
		List<Quarto> quartos = Quarto.find("status = ?", Status.ATIVO).fetch();
		render(quartos);
	}

	public static void remover(Long id) {
		Quarto quarto = Quarto.findById(id);
		quarto.status = Status.INATIVO;
		quarto.save();
		listar();
	}
}