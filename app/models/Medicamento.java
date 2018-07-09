package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import play.db.jpa.Model;

@Entity
public class Medicamento extends Model {
	
	public String nomeMedicamento;
	public String fabricante;
	
	public Date dataPrescrita;
	public int horariodosagem;
	public Date dataAplicar;
	
	@ManyToMany
	@JoinTable(name="leito_id")
	public List<Leito> leitos; 
	
}
