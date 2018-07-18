package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enums.Status;
import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.libs.Crypto;

@Entity
public class Usuario extends Model{
	
	@Required
	@Email
	public String email;
	
	@Required
	public String senha;
	
	@Required
	@Enumerated(EnumType.STRING)
	public Status status;

	@Override
	public String toString() {
		return email;
	}

}
