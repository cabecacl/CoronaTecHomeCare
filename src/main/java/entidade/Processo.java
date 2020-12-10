package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROCESSO")
public class Processo {
	
	@Id
	@Column(name="NOME", nullable=false)
	private String nome;
	
	@Column(name="DESCRICAO", nullable=false)
	private String descricao;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}