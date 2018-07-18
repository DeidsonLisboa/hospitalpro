package jobs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import enums.TipoInternacao;
import models.Ala;
import models.Enfermeiro;
import models.Internacao;
import models.Leito;
import models.Medico;
import models.Paciente;
import models.Quarto;
import models.Usuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.libs.Crypto;

@OnApplicationStart
public class Inicializador extends Job {
	
	public void doJob() throws Exception{
		if(Usuario.count() == 0){
			Usuario usuario = new Usuario();
			usuario.email = "robin@gmail.com";
			usuario.senha = "12345";
			usuario.save();
		}	
		
	}

}
