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
public class Quarto extends GenericModel {
	
	@Expose
	@Id
    @GeneratedValue
    public Long id;
	
	@Expose
	public Integer numeroQuarto;
	
	@OneToMany(mappedBy="quarto")
	public  List<Leito> leitos;
	
	//@Expose(serialize = false)
	@ManyToOne
	@JoinTable(name="ala_id")
	public Ala ala;
	
	@Expose
	@Enumerated(EnumType.STRING)
	public Status status;

	public Quarto() {
		this(null);
	}
	
	public Quarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
		this.status = Status.ATIVO;
		this.leitos = new ArrayList<Leito>();
	}

	@Override
	public String toString() {
		return "Quarto [id=" + id +" numeroQuarto=" + numeroQuarto + "]";
	}
	
	@Expose
	@Enumerated(EnumType.STRING)
	public Status statusleito = Status.ATIVO;
	
	public List<Leito> getLeitosAtivos(){
		return Leito.find("from Leito where quarto = ? and statusleito = ?", 
				this, Status.ATIVO).fetch();
	}
}
