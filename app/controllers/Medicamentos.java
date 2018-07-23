package controllers;

import java.util.Arrays;
import java.util.List;
import com.sun.org.apache.xpath.internal.operations.String;

import annotations.Admin;
import models.Leito;
import models.Medicamento;
import models.Paciente;
import play.mvc.Controller;
import java.util.List;
import models.Medicamento;
import play.mvc.Controller;
import play.mvc.With;

//@Admin
@With(Seguranca.class)
public class Medicamentos extends Controller{
	
	public static void form(Long id, Medicamento medicamento) {
		Leito leito = Leito.findById(id);
		render(medicamento, leito);
	}
	
	public static void salvar(Medicamento medicamento, List<String> LeitosIDs) {		
		
		medicamento.save();
		detalhes(medicamento.id);;
	}
	
	public static void editar(Long id) {
		Medicamento medicamento = Medicamento.findById(id);
		renderTemplate("Medicamentos/form.html", medicamento);
	}
	
	public static void detalhes(Long id) {
		Medicamento medicamento = Medicamento.findById(id);
		render(medicamento);
	}
	
	public static void listar() {
		List<Medicamento> medicamentos = Medicamento.findAll();
		render(medicamentos);
	}
	
	public static void remover(Long id) {
		Medicamento medicamento = Medicamento.findById(id);
		medicamento.delete();
		flash.success("Médicamento removido com sucesso!");
		listar();
	}
}
