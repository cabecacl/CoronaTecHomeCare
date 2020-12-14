package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.AtendimentoDAO;
import dao.AtendimentoDAOImplementacao;
import dao.PacienteDAO;
import dao.PacienteDAOImplementacao;
import dao.ProfissionalDAO;
import dao.ProfissionalDAOImplementacao;
import entidade.Atendimento;
import entidade.Paciente;
import entidade.Processo;
import entidade.Profissional;
import fachada.Fachada;

@ManagedBean(name = "AtendimentoBean")
@RequestScoped
public class AtendimentoBean {
	
	private Profissional profissional;
	private Paciente     paciente;
	private Processo	 processo;

	private Atendimento atendimento;
	private Date dtainicio;
	private Date dtafim;	
	
	private Fachada fachada;
	private ProfissionalDAO profissionalDAO;
	private PacienteDAO pacienteDAO;
	
	
	
	private List<Atendimento> listaAtendimento;
	private List<Profissional> listaProfissional;
	private List<Paciente> listaPaciente;
	
	//Trocar depois
	private AtendimentoDAO atendimentoDAO;
	
	public AtendimentoBean() {
		
		this.fachada = new Fachada();
		this.listaAtendimento = new ArrayList<Atendimento>();
		
		//titar depois
		this.atendimentoDAO = new AtendimentoDAOImplementacao();
		this.profissionalDAO = new ProfissionalDAOImplementacao();
		this.pacienteDAO = new PacienteDAOImplementacao();
		
		this.listaProfissional = this.profissionalDAO.listarProfissionais();
		this.listaPaciente = this.pacienteDAO.listarPacientes();
		
		this.atendimento = new Atendimento();
		this.atendimento.setDta(new Date());
		this.atendimento.setProficional(new Profissional());
		this.atendimento.setPaciente(new Paciente());
		
		this.setDtainicio(new Date());
		this.setDtafim(new Date());
	}
	
	
	public void pesquisar() {
		//tirar depois
		this.listaAtendimento = this.atendimentoDAO.pesquisarAtendimento(atendimento, dtainicio, dtafim);
		System.out.println("chegou aqui"); 
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
	

	public Date getDtainicio() {
		return dtainicio;
	}



	public void setDtainicio(Date dtainicio) {
		this.dtainicio = dtainicio;
	}



	public Date getDtafim() {
		return dtafim;
	}



	public void setDtafim(Date dtafim) {
		this.dtafim = dtafim;
	}


	public List<Atendimento> getListaAtendimento() {
		return listaAtendimento;
	}


	public void setListaAtendimento(List<Atendimento> listaAtendimento) {
		this.listaAtendimento = listaAtendimento;
	}


	public Fachada getFachada() {
		return fachada;
	}


	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}


	public ProfissionalDAO getProfissionalDAO() {
		return profissionalDAO;
	}


	public void setProfissionalDAO(ProfissionalDAO profissionalDAO) {
		this.profissionalDAO = profissionalDAO;
	}


	public PacienteDAO getPacienteDAO() {
		return pacienteDAO;
	}


	public void setPacienteDAO(PacienteDAO pacienteDAO) {
		this.pacienteDAO = pacienteDAO;
	}


	public List<Profissional> getListaProfissional() {
		return listaProfissional;
	}


	public void setListaProfissional(List<Profissional> listaProfissional) {
		this.listaProfissional = listaProfissional;
	}


	public List<Paciente> getListaPaciente() {
		return listaPaciente;
	}


	public void setListaPaciente(List<Paciente> listaPaciente) {
		this.listaPaciente = listaPaciente;
	}


	public AtendimentoDAO getAtendimentoDAO() {
		return atendimentoDAO;
	}


	public void setAtendimentoDAO(AtendimentoDAO atendimentoDAO) {
		this.atendimentoDAO = atendimentoDAO;
	}
	
}
