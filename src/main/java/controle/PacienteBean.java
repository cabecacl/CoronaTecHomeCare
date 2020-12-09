package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "PacienteBean")
@RequestScoped
public class PacienteBean {
	
	private String nomeTelaPaciente;
	private String cpfTelaPaciente;
	private String emailTelaPaciente;
	private String telefoneTelaPaciente;
	private String sexoTelaPaciente;
	private int idadeTelaPaciente;
	private int pesoTelaPaciente;
	private int alturaTelaPaciente;
	private String numeroTelaPaciente;
	private String ruaTelaPaciente;
	private String bairroTelaPaciente;
	private String cepTelaPaciente;
	
	//get set
	public String getNomeTelaPaciente() {
		return nomeTelaPaciente;
	}
	public void setNomeTelaPaciente(String nomeTelaPaciente) {
		this.nomeTelaPaciente = nomeTelaPaciente;
	}
	public String getCpfTelaPaciente() {
		return cpfTelaPaciente;
	}
	public void setCpfTelaPaciente(String cpfTelaPaciente) {
		this.cpfTelaPaciente = cpfTelaPaciente;
	}
	public String getEmailTelaPaciente() {
		return emailTelaPaciente;
	}
	public void setEmailTelaPaciente(String emailTelaPaciente) {
		this.emailTelaPaciente = emailTelaPaciente;
	}
	public String getTelefoneTelaPaciente() {
		return telefoneTelaPaciente;
	}
	public void setTelefoneTelaPaciente(String telefoneTelaPaciente) {
		this.telefoneTelaPaciente = telefoneTelaPaciente;
	}
	public String getSexoTelaPaciente() {
		return sexoTelaPaciente;
	}
	public void setSexoTelaPaciente(String sexoTelaPaciente) {
		this.sexoTelaPaciente = sexoTelaPaciente;
	}
	public int getIdadeTelaPaciente() {
		return idadeTelaPaciente;
	}
	public void setIdadeTelaPaciente(int idadeTelaPaciente) {
		this.idadeTelaPaciente = idadeTelaPaciente;
	}
	public int getPesoTelaPaciente() {
		return pesoTelaPaciente;
	}
	public void setPesoTelaPaciente(int pesoTelaPaciente) {
		this.pesoTelaPaciente = pesoTelaPaciente;
	}
	public int getAlturaTelaPaciente() {
		return alturaTelaPaciente;
	}
	public void setAlturaTelaPaciente(int alturaTelaPaciente) {
		this.alturaTelaPaciente = alturaTelaPaciente;
	}
	public String getNumeroTelaPaciente() {
		return numeroTelaPaciente;
	}
	public void setNumeroTelaPaciente(String numeroTelaPaciente) {
		this.numeroTelaPaciente = numeroTelaPaciente;
	}
	public String getRuaTelaPaciente() {
		return ruaTelaPaciente;
	}
	public void setRuaTelaPaciente(String ruaTelaPaciente) {
		this.ruaTelaPaciente = ruaTelaPaciente;
	}
	public String getBairroTelaPaciente() {
		return bairroTelaPaciente;
	}
	public void setBairroTelaPaciente(String bairroTelaPaciente) {
		this.bairroTelaPaciente = bairroTelaPaciente;
	}
	public String getCepTelaPaciente() {
		return cepTelaPaciente;
	}
	public void setCepTelaPaciente(String cepTelaPaciente) {
		this.cepTelaPaciente = cepTelaPaciente;
	}
	
	


}
