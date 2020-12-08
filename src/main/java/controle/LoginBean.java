package controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import dao.ProfissionalDAO;
import dao.ProfissionalDAOImplementacao;
import entidade.Profissional;

@ManagedBean(name = "LoginBean")
@RequestScoped
public class LoginBean {

	private String cpfTela;
	private String senhaTela;

	private ProfissionalDAO profDAO;

	public LoginBean() {
		profDAO = new ProfissionalDAOImplementacao();
	}

	public String logar() {

		FacesMessage message = null;
		boolean logado = false;

		Profissional profPesquisa = new Profissional();
		profPesquisa.setCpf(cpfTela);// cria pesquisa

		// lista os proficionas para localisar
		List<Profissional> listaBanco = this.profDAO.pesquisarProfissional(profPesquisa);

		if (listaBanco != null && listaBanco.size() > 0) {
			Profissional profBase = listaBanco.get(0);

			if (profBase.getSenha().equals(senhaTela)) {
				return "telaPrincipal.xhtml";
			} else {
				logado = false;
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Errado", "Credenciais inválidas");
			}

		} else {
			logado = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Errado", "Credenciais inválidas");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		PrimeFaces.current().ajax().addCallbackParam("Logado", logado);

		return "";

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
