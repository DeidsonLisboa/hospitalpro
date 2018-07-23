package jobs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import enums.Status;
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
			usuario.status = Status.ATIVO;
			usuario.save();
		}	
		
		
		if(Paciente.count() == 0){
			
			Paciente p1 = new Paciente();
			p1.nome = "Robin";
			p1.sexo = "Masculino";
			p1.dataNas = new Date("1995/11/18");
			p1.nacionalidade = "Brasileiro";
			p1.naturalCidade = "Doutor Severiano";
			p1.naturalEstado = "Rio Grande do Norte";
			p1.tipoSanguineo = "O-";
			p1.profissao = "Estudante";
			p1.estCivil = "solteiro"; 
			p1.cpf = "111111111";
			p1.rg = "12312312";
			p1.cartaoSus = "12345";
			p1.estado = "Rio Grande do Norte";
			p1.cep = "545454";
			p1.cidade = "Doutor Severiano";
			p1.complemento = "casa";
			p1.bairro = "centro";
			p1.rua = "sitio merejo";
			p1.numCasa = "11";
			p1.tel = "1111";
			p1.telAdicional = "3445";
			p1.email = "robin@info.com";
			p1.save();
			
			Medico m1 = new Medico();
			m1.nome = "Matheus";
			m1.estCivil = "solteiro";
			m1.naturalCidade = "Apodi";
			m1.naturalEstado = "Rio Grande do Norte";
			m1.nacionalidade = "Brasileiro";
			m1.sexo = "Masculino";
			m1.dataNas = new Date("1990/12/11");
			m1.cpf = "112222324";
			m1.rg = "445554";
			m1.email = "matheus@info.com";
			m1.nomeFacul = "medicina";
			m1.anoConc = 2015;
			m1.residencia = "222";
			m1.orgResid = "55";
			m1.espPrincipal = "66575";
			m1.titFormacao = "nutricao";
			m1.cep = "fsdf";
			m1.complemento = "casa";
			m1.telefone = "12222";
			m1.UFcrm = "RN";
			m1.numCRM = "747433";
			m1.cidade = "Apodi";
			m1.bairro = "Centro";
			m1.rua = "rua 0";
			m1.numCasa = "34";
			m1.estado = "RN";
			m1.save();
			
			Enfermeiro e1 = new Enfermeiro();
			e1.nome = "Deidson Lisboa";
			e1.sexo = "Masculino";
			e1.dataNas = new Date("1991/11/21");
			e1.estCivil = "Casado";
			e1.naturalCidade = "Dr. Severiano";
			e1.naturalEstado = "Rio Grande do Norte";
			e1.nacionalidade = "Brasileiro";
			e1.rg = "3.333.333.";
			e1.cpf = "333.333.333-33";
			e1.telefone = "(84) 2233-3333";
			e1.UFcoren = "RN";
			e1.numCoren = "000000";
			e1.email = "deidson@info.com"; 
			e1.cidade = "dr severiano";
			e1.bairro = "centro";
			e1.rua = "rua 01";
			e1.numCasa = "88";
			e1.estado = "RN";
			e1.complemento = "Casa";
			e1.cep = "59999-000";
			e1.save();
			
			Ala ala = new Ala();
			ala.nomeAla = "Infantil - Masculina";
			ala.save();
			
			Quarto q1 = new Quarto(1);
			q1.ala = ala;
			q1.save();
			
			Leito l1 = new Leito(1);
			l1.quarto = q1;
			l1.save();
			
			Leito l2 = new Leito(2);
			l2.quarto = q1;
			l2.save();
			
			Quarto q2 = new Quarto(2);
			q2.ala = ala;
			q2.save();
			
			Quarto q3 = new Quarto(3);
			q3.ala = ala;
			q3.save();
			
			
			Ala ala2 = new Ala();
			ala2.nomeAla = "Geriatria - Feminina";
			ala2.save();
			
			Quarto q4 = new Quarto(1);
			q4.ala = ala2;
			q4.save();
			
			Quarto q5 = new Quarto(2);
			q5.ala = ala2;
			q5.save();
			
			Quarto q6 = new Quarto(3);
			q6.ala = ala2;
			q6.save();
		}	
		
	}

}
