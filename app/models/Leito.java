package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.gson.annotations.Expose;

import enums.Status;
import play.db.jpa.GenericModel;
import play.db.jpa.Model;


@Entity
public class Leito extends GenericModel {
	
	@Expose
	@Id
    @GeneratedValue
    public Long id;
	
	@Expose
	public Integer numeroLeito;
	
	@Expose
	public boolean ocupado = false;
	
	@Expose
	@Enumerated(EnumType.STRING)
	public Status status;

	@ManyToOne
	@JoinTable(name="quarto_id")
	public Quarto quarto;
	
	@OneToMany(mappedBy="leito")
	public List<Medicamento> medicamentos;
	
	@OneToMany(mappedBy="leito")
	public List<Internacao> internacao;
	
	@Expose
	@Enumerated(EnumType.STRING)
	public Status statusleito;
	
	public Leito() {
		this(null);
	}
	
	public Leito(Integer numeroLeito) {
		this(numeroLeito, false, Status.ATIVO, new ArrayList<Medicamento>());
	}

	public Leito(Integer numeroLeito, boolean ocupado, Status status, List<Medicamento> medicamentos) {
		super();
		this.numeroLeito = numeroLeito;
		this.ocupado = ocupado;
		this.status = status;
		this.medicamentos = medicamentos;
	}
	
}
