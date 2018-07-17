package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import enums.Status;
import play.db.jpa.Model;

@Entity
public class Leito extends Model {
	
	public Integer numeroLeito;
	public boolean ocupado = false;

	@ManyToOne
	@JoinColumn(name="quarto_id")
	public Quarto quarto;
	
	@OneToMany(mappedBy="leito")
	public List<Medicamento> medicamentos;
	
	@OneToOne(mappedBy="leito")
	public Internacao internacao;
	
	@Enumerated(EnumType.STRING)
	public Status statusleito;
	
	public Leito() {
		this(null, null);
	}
	
	public Leito(Integer numeroLeito, Quarto quarto) {
		this.numeroLeito = numeroLeito;
		this.quarto = quarto;
		this.statusleito = Status.ATIVO;
	}

	@Override
	public String toString() {
		return "Leito [id=" + id +" numeroLeito=" + numeroLeito + "]";
	}
	
}
