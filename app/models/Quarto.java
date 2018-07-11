package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Quarto extends Model {
	
	public String numeroQuarto;
	
	@OneToMany(mappedBy="quarto")
	public  List<Leito> leitos;
	
	@ManyToOne
	@JoinColumn(name="ala_id")
	public Ala ala;

	@Override
	public String toString() {
		return "Quarto [id=" + id +" numeroQuarto=" + numeroQuarto + "]";
	}
}
