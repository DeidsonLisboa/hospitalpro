package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.gson.annotations.Expose;

import enums.Status;
import play.db.jpa.GenericModel;
import play.db.jpa.Model;

@Entity
public class Ala  extends GenericModel{
	
	@Expose
	@Id
    @GeneratedValue
    public Long id;
	
	@Expose
	public String nomeAla;
	
	@Expose
	@OneToMany(mappedBy="ala")
	public  List<Quarto> quartos;
	
	@Expose
	@Enumerated(EnumType.STRING)
	public Status status = Status.ATIVO;
		
	public Ala() {
		this(null, new ArrayList<Quarto>(), Status.ATIVO);
	}

	public Ala(String nomeAla, List<Quarto> quartos, Status status) {
		super();
		this.nomeAla = nomeAla;
		this.quartos = quartos;
		this.status = status;
	}

	public List<Quarto> getQuartosAtivos(){
		return quartos.stream().filter(q -> 
									   q.status == Status.ATIVO).collect(Collectors.toList());
	}
}
