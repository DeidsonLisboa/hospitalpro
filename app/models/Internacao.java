package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import enums.TipoInternacao;
import play.db.jpa.Model;

@Entity
public class Internacao extends Model{
	
	@ManyToMany
	@JoinTable(name="paciente_id")
	public List<Paciente> pacientes;
	
	@ManyToMany
	@JoinTable(name="medico_id")
	public List<Medico> medicos;
	
	@ManyToMany
	@JoinTable(name="enfermerio_id")
	public List<Enfermeiro> enfermeiros;
	
	public String pressao;
	public String temperatura;
	public String peso;
	public String altura;
	public String infoComplementares;
	
	@Enumerated(EnumType.STRING)
	public TipoInternacao tipointernacao;

}
