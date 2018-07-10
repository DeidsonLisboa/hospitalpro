package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Medico extends Model {
	
	//@Required
	public String nome;
	
	
	public String estCivil;
	public String naturalEstado;
	public String naturalCidade;
	public String nacionalidade;

	//@Required
	public String sexo;
	public Blob foto;
	
	//@Required
	@Temporal(TemporalType.DATE)
	public Date dataNas;
	
	//@Required
	public String cpf;
	
	//@Required
	public String rg;
	
	public String email;
	
	//@Required
	public String nomeFacul;
	
	//@Required
	public int anoConc;
	public String residencia;
	public String orgResid;
	
	//@Required
	public String espPrincipal;
	public String titFormacao;
	public String cep;
	public String estado;
	public String complemento;
	public String telefone;
	public String UFcrm;
	
	//@Required
	public String numCRM;
	public String cidade;
	public String bairro;
	public String rua;
	public String numCasa;

	@ManyToMany(mappedBy = "medicos")
	public List<Internacao> internacoes;

}
