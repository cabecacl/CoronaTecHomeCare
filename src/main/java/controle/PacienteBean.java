package controle;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.PacienteDAO;
import dao.PacienteDAOImplementacao;
import entidade.Paciente;
import util.JpaUtil;

@ManagedBean(name = "PacienteBean")
@RequestScoped
public class PacienteBean {
	
	private Paciente paciente;
	
	public PacienteBean() {
		this.paciente = new Paciente();
	}
	
	public void salvar() throws SQLException {
		//salvar ...
		PacienteDAOImplementacao pacienteDAO = new PacienteDAOImplementacao ();
		
		if (pacienteDAO.inserirPaciente(paciente)){
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
