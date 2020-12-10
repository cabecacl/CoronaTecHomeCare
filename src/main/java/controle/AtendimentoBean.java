package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entidade.Atendimento;
import entidade.Paciente;
import entidade.Processo;
import entidade.Profissional;

@ManagedBean(name = "AtendimentoBean")
@RequestScoped
public class AtendimentoBean {

	//Pesquisa do banco
	private List<Profissional> 	listaProfissional;
	private List<Paciente>	   	listaPaciente;
	private List<Processo>		listaProcesso;
	
	//Objs selecionados
	private Atendimento atendimento;
	
	private Profissional profissional;
	private Paciente     paciente;
	private Processo	 processo;
	
	
	public AtendimentoBean() {
		this.listaProfissional  = new ArrayList<Profissional>();
		this.listaPaciente		= new ArrayList<Paciente>();
		this.listaProcesso		= new ArrayList<Processo>();
		
		this.atendimento = new Atendimento();
		this.atendimento.setDta(new Date());
		
		this.profissional = new Profissional();		
		this.processo     = new Processo();
		this.paciente 	  = new Paciente();
	}
	
	//GETTERS & SETTERS
	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	
	
}
