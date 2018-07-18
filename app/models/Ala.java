package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import enums.Status;
import play.db.jpa.Model;

@Entity
public class Ala extends Model{
	
	public String nomeAla;
		
	@OneToMany(mappedBy="ala")
	public  List<Quarto> quartos;
	
	
	@Enumerated(EnumType.STRING)
	public Status status = Status.ATIVO;
	
	public List<Quarto> getQuartosAtivos(){
		return Quarto.find("from Quarto where ala = ? and status = ?", 
				this, Status.ATIVO).fetch();
	}
}
