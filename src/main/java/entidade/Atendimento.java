package entidade;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ATENDIMENTO")
public class Atendimento {
	@Id
	@Column(name = "ID_ATENDIMENTO", nullable = false)
	@GeneratedValue(generator = "S_ATENDIMENTO")
	@SequenceGenerator(name = "S_ATENDIMENTO", sequenceName = "S_ATENDIMENTO", allocationSize = 1)
	private int idatendimento;

	@Column(name = "DTA", nullable = false)
	private Date dta;

	@Column(name = "CID", nullable = false)
	private String cid;

	@Column(name = "AVALIACAO", nullable = false)
	private String avaliacao;

	@Column(name = "EVOLUCAO", nullable = false)
	private String evolucao;

	@Column(name = "PRESCRIAO", nullable = false)
	private String prescriao;

	@Column(name = "OBS", nullable = false)
	private String obs;

	@Column(name = "CONDUTA", nullable = false)
	private String conduta;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PROFIS", referencedColumnName = "ID_PROFIS", nullable = false)
	private Profissional proficional;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID_PACIENTE", nullable = false)
	private Paciente paciente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NOME", referencedColumnName = "NOME", nullable = false)
	private Processo processo;

	

	public int getIdatendimento() {
		return idatendimento;
	}

	public void setIdatendimento(int idatendimento) {
		this.idatendimento = idatendimento;
	}

	public Date getDta() {
		return dta;
	}

	public void setDta(Date dta) {
		this.dta = dta;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getEvolucao() {
		return evolucao;
	}

	public void setEvolucao(String evolucao) {
		this.evolucao = evolucao;
	}

	public String getPrescriao() {
		return prescriao;
	}

	public void setPrescriao(String prescriao) {
		this.prescriao = prescriao;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getConduta() {
		return conduta;
	}

	public void setConduta(String conduta) {
		this.conduta = conduta;
	}

	public Profissional getProficional() {
		return proficional;
	}

	public void setProficional(Profissional proficional) {
		this.proficional = proficional;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	
}