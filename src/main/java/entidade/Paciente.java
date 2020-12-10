package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PACIENTE")
public class Paciente {
	@Id
	@Column(name="ID_PACIENTE", nullable=false)
	@GeneratedValue(generator = "S_PACIENTE")
	@SequenceGenerator(name = "S_PACIENTE", sequenceName = "S_PACIENTE", allocationSize = 1)
	private int idpaciente;
	
	@Column(name="NOME", nullable=false)
	private String nome;
	
	@Column(name="CPF", nullable=false)
	private String cpf;

	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@Column(name="TELEFONE", nullable=false)
	private String telefone;
	
	@Column(name="SEXO", nullable=false)
	private String sexo;
	
	@Column(name="IDADE", nullable=false)
	private int idade;
	
	@Column(name="PESO", nullable=false)
	private int peso;
	
	@Column(name="ALTURA", nullable=false)
	private int altura;
	
	@Column(name="RUA", nullable=false)
	private String rua;
	
	@Column(name="NUMERO", nullable=false)
	private String numero;
	
	@Column(name="BAIRRO", nullable=false)
	private String bairro;
	
	@Column(name="CEP", nullable=false)
	private String cep;

	public int getIdpaciente() {
		return idpaciente;
	}

	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
