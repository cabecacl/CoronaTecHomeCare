package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entidade.Profissional;
import fachada.Fachada;

@ManagedBean(name = "CadastroBean")
@RequestScoped
public class CadastroBean {

	private Profissional profissional;
	private Fachada fachada;
	
	public CadastroBean() {
		this.fachada = new Fachada();
		this.profissional = new Profissional();
	}

	public void salvar() {
		this.fachada.inserirProfissional(profissional);
		
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
	
}
