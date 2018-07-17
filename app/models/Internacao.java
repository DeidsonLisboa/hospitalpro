package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import enums.TipoInternacao;
import play.db.jpa.Model;

@Entity
public class Internacao extends Model{
	
	@OneToOne
	@JoinColumn(name="paciente_id")
	public Paciente paciente;
	
	@OneToOne
	@JoinColumn(name="medico_id")
	public Medico medico;
	
	@OneToOne
	@JoinColumn(name="enfermerio_id")
	public Enfermeiro enfermeiro;
	
	@OneToOne
	@JoinColumn(name="leito_id")
	public Leito leito;
	
	public String pressao;
	public String temperatura;
	public String peso;
	public String altura;
	public String infoComplementares;
	
	@Enumerated(EnumType.STRING)
	public TipoInternacao tipointernacao;

}
