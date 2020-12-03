package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entidade.Profissional;

@ManagedBean(name = "AtendimentoBean")
@RequestScoped
public class AtendimentoBean {

	private Long 	id;
	private String	data;
	private String	cid;
	private String 	avaliacao;
	private String	evolucao;
	private String 	prescricao;
	private String 	obs;
	private String 	conduta;
	
	private Profissional profissional;
	//private Paciente 	 paciente;
	
	//private List<Processo> listaProcessos;
	
}
