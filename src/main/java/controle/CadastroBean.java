package controle;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "CadastroBean")
@RequestScoped
public class CadastroBean {


	private String nomeTela;
	private String cpfTela;
	private long numRegTela;
	private String tipoProfTela;
	private String senhaTela;
	private String areaTela;
	private String emailTela;
	private String telefoneTela;
	
	
	
	//get set
	public String getNomeTela() {
		return nomeTela;
	}
	public void setNomeTela(String nomeTela) {
		this.nomeTela = nomeTela;
	}
	public String getCpfTela() {
		return cpfTela;
	}
	public void setCpfTela(String cpfTela) {
		this.cpfTela = cpfTela;
	}
	public long getNumRegTela() {
		return numRegTela;
	}
	public void setNumRegTela(long numRegTela) {
		this.numRegTela = numRegTela;
	}
	public String getTipoProfTela() {
		return tipoProfTela;
	}
	public void setTipoProfTela(String tipoProfTela) {
		this.tipoProfTela = tipoProfTela;
	}
	public String getSenhaTela() {
		return senhaTela;
	}
	public void setSenhaTela(String senhaTela) {
		this.senhaTela = senhaTela;
	}
	public String getAreaTela() {
		return areaTela;
	}
	public void setAreaTela(String areaTela) {
		this.areaTela = areaTela;
	}
	public String getEmailTela() {
		return emailTela;
	}
	public void setEmailTela(String emailTela) {
		this.emailTela = emailTela;
	}
	public String getTelefoneTela() {
		return telefoneTela;
	}
	public void setTelefoneTela(String telefoneTela) {
		this.telefoneTela = telefoneTela;
	}


	

	
	


}
