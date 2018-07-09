package controllers;

import java.util.Arrays;
import java.util.List;
import com.sun.org.apache.xpath.internal.operations.String;
import models.Medicamento;
import models.Paciente;
import play.mvc.Controller;
import java.util.List;
import models.Medicamento;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Medicamentos extends Controller{
	
	public static void form(Medicamento medicamento) {
		render(medicamento);
	}
	
	public static void salvar(Medicamento medicamento) {
		medicamento.save();
		flash.success("Médicamento cadastrado com sucesso!");
		listar();
	}
	
	public static void editar(Long id) {
		Medicamento medicamento = Medicamento.findById(id);
		renderTemplate("Medicamentos/editar.html", medicamento);
	}
	
	public static void detalhes(Medicamento medicamento) {
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
