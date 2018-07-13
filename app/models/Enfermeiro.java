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
public class Enfermeiro extends Model {

	//@Required
	public String senha;
		
	//@Required
	public String login;
	
	//@Required
	public String nome;
	
	//@Required
	public String sexo;
	
	public Blob foto;
	
	//@Required
	@Temporal(TemporalType.DATE)
	public Date dataNas;

	public String estCivil;
	public String naturalEstado;
	public String naturalCidade;
	public String nacionalidade;
	
	//@Required
	public String rg;
	
	//@Required
	public String cpf;
	
	//@Required
	public String telefone;
	public String UFcoren;
	
	//@Required
	public String numCoren;
	public String email;
	public String cidade;
	public String bairro;
	public String rua;
	public String numCasa;
	public String complemento;
	public String estado;
	public String cep;

	@ManyToMany(mappedBy = "enfermeiros")
	public List<Internacao> internacoes;

}
