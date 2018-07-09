package controllers;

import java.util.Arrays;
import java.util.List;

import models.Enfermeiro;
import models.Paciente;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Pacientes extends Controller {
	
	public static void form() {
		List<String> sexos = Arrays.asList(new String[]{"Masculino", "Feminino", "Outros",});
		//List<String> estados = Arrays.asList(new String[]{"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Sul", "Rio Grande do Norte", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"});
		List<String> tiposSanguineos = Arrays.asList(new String[]{"A+", "A-", "B+", "B-", "AB+","AB-", "O+", "O-"});
		List<String> nacionalidades = Arrays.asList(new String[]{"Brasileira", "Estrangeira"});
		List<String> estadosCivis = Arrays.asList(new String[]{"Solteiro(a)", "Casado(a)", "Divociado(a)", "Viúvo(a)", "Outro"});
		render(sexos, tiposSanguineos, nacionalidades, estadosCivis);
	}
	
	public static void salvar(@Valid Paciente paciente) {
		System.out.println(params.get("excluirFoto"));
		if(params.get("excluirFoto") != null) {
			paciente.foto.getFile().delete();
		}
		
		System.out.println(validation.hasErrors());
		
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			form();
		}
		paciente.save();
		flash.success("Paciente cadastrado com sucesso!");
		listar();
	}
	
	public static void editar(Long id) {
		Paciente paciente = Paciente.findById(id);
		List<String> sexos = Arrays.asList(new String[]{"Masculino", "Feminino", "Outros",});
		//List<String> estados = Arrays.asList(new String[]{"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Sul", "Rio Grande do Norte", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"});
		List<String> tiposSanguineos = Arrays.asList(new String[]{"A+", "A-", "B+", "B-", "AB+","AB-", "O+", "O-"});
		List<String> nacionalidades = Arrays.asList(new String[]{"Brasileira", "Estrangeira"});
		List<String> estadosCivis = Arrays.asList(new String[]{"Solteiro(a)", "Casado(a)", "Divociado(a)", "Viúvo(a)", "Outro"});
		renderTemplate("Pacientes/form.html", paciente, sexos, tiposSanguineos, nacionalidades, estadosCivis);
	}
	
	public static void detalhes(Long id) {
		Paciente paciente = Paciente.findById(id);
		render(paciente);
	}
	
	public static void listar() {
		List<Paciente> pacientes = Paciente.findAll();
		render(pacientes);
	}
	
	public static void remover(Long id) {
		Paciente paciente = Paciente.findById(id);
		paciente.delete();
		flash.success("Paciente removido com sucesso!");
		listar();
	}
	
	public static void fotoPaciente(Long id) {
		Paciente paciente = Paciente.findById(id);
	    notFoundIfNull(paciente);
	    response.setContentTypeIfNotSet(paciente.foto.type());
	    renderBinary(paciente.foto.get());
	}
}