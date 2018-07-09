package models;

import javax.persistence.Entity;

import play.db.jpa.Model;
import play.libs.Crypto;

@Entity
public class Usuario extends Model{
	
	public String email;
	public String senha;
	
	public boolean autenticar() {		
		Usuario u = Usuario.find("email = ? and senha = ?", email, Crypto.passwordHash(senha)).first();

		if (u == null) {
			return false;
		} else {
			return true;
		}
	}

}
