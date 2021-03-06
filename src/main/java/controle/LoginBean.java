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
import fachada.Fachada;

@ManagedBean(name = "LoginBean")
@RequestScoped
public class LoginBean {

	private String cpfTela;
	private String senhaTela;

	private Fachada proflogin;

	public LoginBean() {
		this.proflogin = new Fachada();
	}

	public String logar() {

		FacesMessage message = null;
		boolean logado = false;

		Profissional profPesquisa = new Profissional();
		profPesquisa.setCpf(cpfTela);// cria pesquisa

		// lista os proficionas para localisar
		List<Profissional> listaBanco = this.proflogin.pesquisarProfissional(profPesquisa);

		if (listaBanco != null && listaBanco.size() > 0) {
			Profissional profBase = listaBanco.get(0);

			if (profBase.getSenha().equals(senhaTela)) {
				return "telaPrincipal.xhtml";
			} else {
				logado = false;
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Errado", "Senha invalido");
			}

		} else {
			logado = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Errado", "Usuário Não Cadastrado");
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

	public Fachada getProflogin() {
		return proflogin;
	}

	public void setProflogin(Fachada proflogin) {
		this.proflogin = proflogin;
	}
}
