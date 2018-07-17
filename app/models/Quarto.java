package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import enums.Status;
import play.db.jpa.Model;

@Entity
public class Quarto extends Model {
	
	public Integer numeroQuarto;
	
	@OneToMany(mappedBy="quarto")
	public  List<Leito> leitos;
	
	@ManyToOne
	@JoinColumn(name="ala_id")
	public Ala ala;
	
	@Enumerated(EnumType.STRING)
	public Status status;

	public Quarto() {
		this(null, null);
	}
	
	public Quarto(Integer numeroQuarto, Ala ala) {
		this.numeroQuarto = numeroQuarto;
		this.ala = ala;
		this.status = Status.ATIVO;
	}

	@Override
	public String toString() {
		return "Quarto [id=" + id +" numeroQuarto=" + numeroQuarto + "]";
	}
	
	@Enumerated(EnumType.STRING)
	public Status statusleito = Status.ATIVO;
	
	public List<Leito> getLeitosAtivos(){
		return Leito.find("from Leito where quarto = ? and statusleito = ?", 
				this, Status.ATIVO).fetch();
	}
}
