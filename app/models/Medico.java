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

	public String nome;
	public String estCivil;
	public String naturalEstado;
	public String naturalCidade;
	public String nacionalidade;
	public String sexo;
	public Blob foto;

	@Temporal(TemporalType.DATE)
	public Date dataNas;

	public String cpf;
	public String rg;
	public String email;
	public String nomeFacul;
	public int anoConc;
	public String residencia;
	public String orgResid;
	public String espPrincipal;
	public String titFormacao;
	public String cep;
	public String estado;
	public String complemento;
	public String telefone;
	public String UFcrm;
	public String numCRM;
	public String cidade;
	public String bairro;
	public String rua;
	public String numCasa;

	@ManyToMany(mappedBy = "medicos")
	public List<Internacao> internacoes;

}
