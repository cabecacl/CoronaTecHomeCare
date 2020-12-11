package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entidade.Paciente;

@ManagedBean(name = "PacienteBean")
@RequestScoped
public class PacienteBean {
	
	private Paciente paciente;
	
	public PacienteBean() {
		this.paciente = new Paciente();
	}
	
	public void salvar() {
		//salvar ...
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	

}
