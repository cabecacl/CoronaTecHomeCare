package fachada;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.AtendimentoDAO;
import dao.AtendimentoDAOImplementacao;
import dao.PacienteDAO;
import dao.PacienteDAOImplementacao;
import dao.ProfissionalDAO;
import dao.ProfissionalDAOImplementacao;
import entidade.Atendimento;
import entidade.Paciente;
import entidade.Processo;
import entidade.Profissional;
import util.JpaUtil;

public class Fachada {

	private PacienteDAO pacienteDAO;
	private AtendimentoDAO atendimentoDAO;
	private ProfissionalDAO profissionalDAO;

	public Fachada() {
		this.pacienteDAO = new PacienteDAOImplementacao();
		this.atendimentoDAO = new AtendimentoDAOImplementacao();
		this.profissionalDAO = new ProfissionalDAOImplementacao();
	}

//Inserir Paciente	
	public boolean inserirPaciente(Paciente paciente) {

		Paciente pacienteExiste = this.pacienteDAO.pesquisarPaciente(paciente.getCpf());
		
		if(pacienteExiste != null) {
			return false;
		}else {
			return this.pacienteDAO.inserirPaciente(paciente);
		}
	}

//Alterar Paciente

	public boolean alterarPaciente(Paciente paciente) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Paciente existe = ent.find(Paciente.class, paciente.getIdpaciente());

		if (existe != null) {
			existe.setNome(paciente.getNome());
			existe.setAltura(paciente.getAltura());
			existe.setSexo(paciente.getSexo());
			existe.setCpf(paciente.getCpf());
			existe.setIdade(paciente.getIdade());
			existe.setEmail(paciente.getEmail());
			existe.setPeso(paciente.getPeso());
			existe.setTelefone(paciente.getTelefone());
			existe.setRua(paciente.getRua());
			existe.setNumero(paciente.getNumero());
			existe.setCep(paciente.getCep());

			ent.merge(paciente);
			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}
	}

//Remover Paciente

	public boolean removerPaciente(Paciente paciente) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Paciente existe = ent.find(Paciente.class, paciente.getIdpaciente());

		if (existe != null) {

			ent.remove(existe);
			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}

	}

//Pesquisar Paciente

	public List<Paciente> pesquisarPaciente(Paciente paciente) {
		String sql = "from Paciente p where 1=1" + montarWhere(paciente);
		return null;
	}

//String montarWhere
	private String montarWhere(Paciente paciente) {
		String where = "1";

		if (paciente.getCpf() != null && !paciente.getNome().isEmpty()) {
			where += "and p.cpf = " + paciente.getCpf() + "'";
		} else {
			if (paciente.getNome() != null && !paciente.getNome().isEmpty()) {
				where += "and p.nome like '%" + paciente.getNome() + "%'";
			}
			if (paciente.getIdade() > 0) {
				where += "and p.idade = " + paciente.getIdade();
			}
			if (paciente.getSexo() != null && !paciente.getSexo().isEmpty()) {
				where += "and p.sexo like '%" + paciente.getSexo() + "'";
			}
		}
		return null;
	}

//Inserir atendimento

	public boolean inserirAtendimento(Atendimento atendimento) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();
		ent.merge(atendimento);
		tx.commit();
		ent.close();

		return true;

	}

//Alterar Atendimento

	public boolean alterarAtendimento(Atendimento atendimento) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Atendimento existe = ent.find(Atendimento.class, atendimento.getIdatendimento());

		if (existe != null) {
			existe.setDta(atendimento.getDta());
			existe.setCid(atendimento.getCid());
			existe.setAvaliacao(atendimento.getAvaliacao());
			existe.setEvolucao(atendimento.getEvolucao());
			existe.setPrescriao(atendimento.getPrescriao());
			existe.setObs(atendimento.getObs());
			existe.setConduta(atendimento.getConduta());

			ent.merge(atendimento);
			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}
	}

//Remover Atendimento

	public boolean removerAtendimento(Atendimento atendimento) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Atendimento existe = ent.find(Atendimento.class, atendimento.getIdatendimento());

		if (existe != null) {

			ent.remove(atendimento);
			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}
	}

//Inserir Profissional	

	public boolean inserirProfissional(Profissional profissional) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();
		ent.merge(profissional);
		tx.commit();
		ent.close();

		return true;
	}

//Alterar Profissional

	public boolean alterarProfissional(Profissional profissional) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Profissional existe = ent.find(Profissional.class, profissional.getCpf());

		if (existe != null) {
			existe.setNome(profissional.getNome());
			existe.setCpf(profissional.getCpf());
			existe.setEmail(profissional.getEmail());
			existe.setTelefone(profissional.getTelefone());
			existe.setArea(profissional.getArea());
			existe.setNumeroRegistro(profissional.getNumeroRegistro());
			existe.setTipoProfissional(profissional.getTipoProfissional());
			existe.setSenha(profissional.getSenha());

			ent.merge(profissional);
			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}
	}

//Remover Pofissional

	public boolean removerProfissional(Profissional profissional) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Profissional existe = ent.find(Profissional.class, profissional.getCpf());

		if (existe != null) {

			ent.remove(profissional);
			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}

	}

//Pesquisar Profissional

	public List<Profissional> pesquisarProfissional(Profissional profissional){
		return this.profissionalDAO.pesquisarProfissional(profissional);
	}

//Inserir Processo	

	public boolean inserirProcesso(Processo processo) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();
		ent.merge(processo);
		tx.commit();
		ent.close();

		return true;

	}
//Alterar Processo

	public boolean alterarProcesso(Processo processo) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Processo existe = ent.find(Processo.class, processo.getNome());

		if (existe != null) {
			existe.setNome(processo.getNome());
			existe.setDescricao(processo.getDescricao());

			ent.merge(processo);
			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}
	}

//Remover Paciente

	public boolean removerPaciente(Processo processo) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Processo existe = ent.find(Processo.class, processo.getNome());

		if (existe != null) {

			ent.remove(processo);
			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}

	}

//Pesquisar Paciente

	/*
	 * public List<Paciente> pesquisarPaciente(Paciente paciente) { String sql =
	 * "from Paciente p where 1=1" + montarWhere(paciente); return null; }
	 * 
	 * //String montarWhere private String montarWhere(Paciente paciente) { String
	 * where = "";
	 * 
	 * if (paciente.getCpf() != null && !paciente.getNome().isEmpty()) { where +=
	 * "and p.cpf = " + paciente.getCpf() + "'"; }else { if (paciente.getNome() !=
	 * null && !paciente.getNome().isEmpty()) { where += "and p.nome like '%" +
	 * paciente.getNome() + "%'"; } if(paciente.getIdade() > 0) { where +=
	 * "and p.idade = " + paciente.getIdade(); } if (paciente.getSexo() != null &&
	 * !paciente.getSexo().isEmpty()) { where += "and p.sexo like '%" +
	 * paciente.getSexo() + "'"; } } return null; }
	 */
}
