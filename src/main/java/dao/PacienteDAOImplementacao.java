package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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
		String sql = "from Paciente p where p.cpf = ?";

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);
		query.setParameter(1, cpf);

		List<Paciente> lista = query.getResultList();

		ent.close();
		
		if(lista != null && lista.size() > 0) {
			return lista.get(0);
		}else {
			return null;
		}
	}

	@Override
	public List<Paciente> pesquisarPaciente(Paciente paciente) {
		
		return null;
	}

	@Override
	public List<Paciente> listarPacientes() {
		
		String sql = "from Paciente p";

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);

		List<Paciente> listaPacientes = query.getResultList();

		ent.close();

		return listaPacientes;
	}

}
