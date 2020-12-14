package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entidade.Profissional;
import fachada.Fachada;

@ManagedBean(name = "ProfissionalBean")
@RequestScoped
public class ProfissionalBean {

	private Profissional profissional;
	private Fachada fachada;
	private List<Profissional> listaProfissional;
	
	public ProfissionalBean() {
		this.fachada = new Fachada();
		this.profissional = new Profissional();
		this.listaProfissional = new ArrayList<Profissional>();
	}

	public void salvar() {
		this.fachada.inserirProfissional(profissional);
		
	}
	
	public void pesquisar() {
		this.listaProfissional = fachada.pesquisarProfissional(this.profissional);
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public List<Profissional> getListaProfissional() {
		return listaProfissional;
	}

	public void setListaProfissional(List<Profissional> listaProfissional) {
		this.listaProfissional = listaProfissional;
	}
	
	
}
