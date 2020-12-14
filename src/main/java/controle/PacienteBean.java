package controle;

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
	
	public PacienteBean() {
		this.paciente = new Paciente();
		this.fachada = new Fachada();
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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	

}
