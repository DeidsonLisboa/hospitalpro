package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Paciente extends Model {
	
	//@Required
	public String nome;
	
	//@Required
	public String sexo;
	
	
	@Temporal(TemporalType.DATE)
	public Date dataNas;
	
	//@Required
	public String nacionalidade;
	public String naturalCidade;
	public String naturalEstado;
	
	public Blob foto;
	public String tipoSanguineo;
	
	//@Required
	public String profissao;
	public String estCivil; 
	public String cpf;
	public String rg;
	
	public String cartaoSus;
	public String estado;
	public String cep;
	public String cidade;
	public String complemento;
	public String bairro;
	public String rua;
	public String numCasa;
	public String tel;
	public String telAdicional;
	public String email;
	
	@ManyToMany(mappedBy="pacientes")
	public List<Internacao>internacoes;
	
}