package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Medico extends Model {
	
	@Required
	public String nome;
	
	@Required
	public String estCivil;

	@Required
	public String naturalEstado;

	@Required
	public String naturalCidade;

	@Required
	public String nacionalidade;

	@Required
	public String sexo;
	public Blob foto;
	
	@Required
	@Temporal(TemporalType.DATE)
	public Date dataNas;
	
	@Required
	public String cpf;
	
	@Required
	public String rg;
	
	@Required
	public String email;
	
	@Required
	public String nomeFacul;
	
	@Required
	public int anoConc;
	
	@Required
	public String residencia;

	@Required
	public String orgResid;
	
	@Required
	public String espPrincipal;

	@Required
	public String titFormacao;

	@Required
	public String cep;

	@Required
	public String estado;

	@Required
	public String complemento;

	@Required
	public String telefone;

	@Required
	public String UFcrm;
	
	@Required
	public String numCRM;

	@Required
	public String cidade;

	@Required
	public String bairro;

	@Required
	public String rua;

	@Required
	public String numCasa;

	@OneToOne(mappedBy = "medico")
	public Internacao internacao;

}