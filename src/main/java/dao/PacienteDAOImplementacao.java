package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.Paciente;
import util.JpaUtil;

public class PacienteDAOImplementacao implements PacienteDAO {

	@Override
	public boolean inserirPaciente(Paciente paciente) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		ent.merge(paciente);

		tx.commit();
		ent.close();

		return true;

	}

	@Override
	public boolean alterarPaciente(Paciente paciente) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Paciente existe = ent.find(Paciente.class, paciente.getIdpaciente());

		if (existe != null) {
			existe.setNome(paciente.getNome());
			existe.setCpf(paciente.getCpf());
			existe.setEmail(paciente.getEmail());
			existe.setSexo(paciente.getSexo());
			existe.setIdade(paciente.getIdade());
			existe.setPeso(paciente.getPeso());
			existe.setAltura(paciente.getAltura());
			existe.setRua(paciente.getRua());
			existe.setNumero(paciente.getNumero());
			existe.setBairro(paciente.getBairro());
			existe.setCep(paciente.getCep());

			ent.merge(paciente);

			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean removerPaciente(Paciente paciente) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		Paciente existe = ent.find(Paciente.class, paciente.getIdpaciente());

		tx.begin();

		if (existe != null) {
			ent.remove(existe);
			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Paciente pesquisarPaciente(String cpf) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		
		Paciente paciente = null;
		
		tx.begin();
		
		Paciente existe = ent.find(Paciente.class, cpf);
		
		if (existe != null) {
			paciente = existe;
		}

		return paciente;
	}

	@Override
	public List<Paciente> pesquisarPaciente(Paciente paciente) {

		return null;
	}

}
