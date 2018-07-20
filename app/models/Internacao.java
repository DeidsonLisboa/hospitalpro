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
	
	@ManyToOne
	@JoinTable(name="paciente_id")
	public Paciente paciente;
	
	@ManyToOne
	@JoinTable(name="medico_id")
	public Medico medico;
	
	@ManyToOne
	@JoinTable(name="enfermerio_id")
	public Enfermeiro enfermeiro;
	
	@ManyToOne
	@JoinTable(name="leito_id")
	public Leito leito;
	
	public String pressao;
	public String temperatura;
	public String peso;
	public String altura;
	public String infoComplementares;
	
	@Enumerated(EnumType.STRING)
	public TipoInternacao tipointernacao;

}
