package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entidade.Profissional;
import fachada.Fachada;

@ManagedBean(name = "ProfissionalBean")
@RequestScoped
public class ProfissionalBean {

	private Profissional profissional;
	private Fachada fachada;
	
	public ProfissionalBean() {
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
