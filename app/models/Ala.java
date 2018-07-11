package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import enums.TipoCorAla;
import play.db.jpa.Model;

@Entity
public class Ala extends Model{
	
	public String nomeAla;
		
	@OneToMany(mappedBy="ala")
	public  List<Quarto> quartos;
	
	@ManyToMany(mappedBy="alas")
	public List<Internacao>internacoes;
	

}
