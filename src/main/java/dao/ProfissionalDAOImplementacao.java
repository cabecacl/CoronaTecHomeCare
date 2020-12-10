package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Profissional;
import util.JpaUtil;

public class ProfissionalDAOImplementacao implements ProfissionalDAO {

	@Override
	public boolean inserirProfissional(Profissional profissional) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		ent.merge(profissional);

		tx.commit();
		ent.close();

		return true;
	}

	@Override
	public boolean alterarProfissional(Profissional profissional) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Profissional existe = ent.find(Profissional.class, profissional.getId());

		if (existe != null) {
			existe.setNome(profissional.getNome());
			existe.setCpf(profissional.getCpf());
			existe.setNumeroRegistro(profissional.getNumeroRegistro());
			existe.setTipoProfissional(profissional.getTipoProfissional());
			existe.setSenha(profissional.getSenha());
			existe.setArea(profissional.getArea());
			existe.setEmail(profissional.getEmail());
			existe.setTelefone(profissional.getTelefone());

			ent.merge(profissional);

			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean removerProfissional(Profissional profissional) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		Profissional existe = ent.find(Profissional.class, profissional.getId());

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
	public Profissional pesquisarProfissional(String cpf) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		Profissional profissional = null;

		tx.begin();

		Profissional existe = ent.find(Profissional.class, cpf);

		if (existe != null) {
			profissional = existe;
		}

		return profissional;
	}

	@Override
	public List<Profissional> pesquisarProfissional(Profissional profissional) {
		
		return null;
	}

	@Override
	public List<Profissional> listarProfissionais() {
		
		String sql = "from Profissional p";

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);

		List<Profissional> listaProfissionais = query.getResultList();

		ent.close();

		return listaProfissionais;
	}

}
