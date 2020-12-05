package controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;


@ManagedBean(name = "LoginBean")
@RequestScoped
public class LoginBean {

	
	private String cpfTela;
	private String senhaTela;
		
	public void logar() {

		String cpfTeste = "admin";
		String senhaTeste = "12345";
		FacesMessage message = null;
		boolean logado = false;
		if(this.cpfTela != null & this.cpfTela.equals(cpfTeste) && this.senhaTela != null & this.senhaTela.equals(senhaTeste)) {
			logado = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo(a)", cpfTeste);
		}else {
			logado = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Errado", "Credenciais inválidas");
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
		PrimeFaces.current().ajax().addCallbackParam("Logado", logado);
			
	}

	public String getCpfTela() {
		return cpfTela;
	}

	public void setCpfTela(String cpfTela) {
		this.cpfTela = cpfTela;
	}

	public String getSenhaTela() {
		return senhaTela;
	}

	public void setSenhaTela(String senhaTela) {
		this.senhaTela = senhaTela;
	}
	

	
	


}
