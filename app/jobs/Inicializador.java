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
			usuario.senha = Crypto.passwordHash("12345");
			usuario.save();
		}
		/*
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
			p1.numCasa = 11;
			p1.tel = "1111";
			p1.telAdicional = "3445";
			p1.email = "robin@info.com";
			p1.save();
			
			Medico m1 = new Medico();
			m1.nome = "matheus";
			m1.estCivil = "solteiro";
			m1.naturalCidade = "Apodi";
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
			m1.estResidencia = "rn";
			m1.complemento = "casa";
			m1.telefone = "12222";
			m1.numCRM = "7474";
			m1.cidade = "apodi";
			m1.bairro = "centro";
			m1.rua = "rua 0";
			m1.numCasa = 34;
			m1.estado = "rn";
			m1.save();
			
			Enfermeiro e1 = new Enfermeiro();
			e1.nome = "deidson lisboa";
			e1.sexo = "masculino";
			e1.dataNas = new Date("1991/11/21");
			e1.estCivil = "casado";
			e1.naturalCidade = "dr severiano";
			e1.nacionalidade = "brasileiro";
			e1.rg = "355";
			e1.cpf = "23456";
			e1.telefone = "2233";
			e1.numCoren = "7329";
			e1.email = "deidson@info.com"; 
			e1.cidade = "dr severiano";
			e1.bairro = "centro";
			e1.rua = "rua 01";
			e1.numCasa = 88;
			e1.estado = "rn";
			e1.complemento = "casa";
			e1.estResidencia = "rn";
			e1.cep = "59000";
			e1.save();
			
			
			Internacao internacao = new Internacao();
			internacao.pacientes = Arrays.asList(new Paciente[] {p1});
			internacao.pressao = "20.3 C";
			internacao.temperatura = "30 C";
			internacao.peso = "60 kg";
			internacao.altura = "1.70 m";
			internacao.infoComplementares = "paciente mal";
			internacao.tipointernacao = TipoInternacao.GRAVE;
			internacao.medicos = Arrays.asList(new Medico[] {m1});
			internacao.enfermeiros = Arrays.asList(new Enfermeiro[] {e1});
			internacao.save();
		}
		*/
		
		
	}

}
