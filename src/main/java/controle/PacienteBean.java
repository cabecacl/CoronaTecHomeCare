package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entidade.Paciente;
import fachada.Fachada;

@ManagedBean(name = "PacienteBean")
@RequestScoped
public class PacienteBean {
	
	private Paciente paciente;
	private Fachada fachada;
	private List<Paciente> listaPaciente;
	
	public PacienteBean() {
		this.fachada = new Fachada();
		this.paciente = new Paciente();
		this.listaPaciente = new ArrayList<Paciente>();
	}
	
	public void salvar() {
		//salvar ...
		
		if (this.fachada.inserirPaciente(paciente)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso!", "Paciente cadastrado!"));
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro no cadastro!"));
		}

	}
	
	public void pesquisar() {
		this.listaPaciente = fachada.pesquisarPaciente(this.paciente);
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getListaPaciente() {
		return listaPaciente;
	}

	public void setListaPaciente(List<Paciente> listaPaciente) {
		this.listaPaciente = listaPaciente;
	}
	

}
