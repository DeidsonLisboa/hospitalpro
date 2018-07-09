package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

import play.db.jpa.Model;

@Entity
public class Leito extends Model {
	
	public String numeroLeito;
	public boolean ocupado = false;

	@ManyToOne
	@JoinColumn(name="quarto_id")
	public Quarto quarto;
	
	@ManyToMany(mappedBy="leitos")
	public List<Medicamento> medicamentos;
	
}
