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

		String sql = "from Profissional p where p.cpf = ?";

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);
		query.setParameter(1, cpf);

		List<Profissional> lista = query.getResultList();

		ent.close();

		if (lista != null && lista.size() > 0) {
			return lista.get(0);
		} else {
			return null;
		}

	}

	@Override
	public List<Profissional> pesquisarProfissional(Profissional profissional) {
		String sql = "from Profissional p where 1=1 " + montarWhere(profissional);

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);

		List<Profissional> listaProfissional = query.getResultList();

		ent.close();

		return listaProfissional;
	}

	// String montarWhere
	private String montarWhere(Profissional profissional) {
		String where = " ";

		if(profissional.getNome() != null && !profissional.getNome().isEmpty()) {
			where += " and p.nome LIKE '%" + profissional.getNome() + "%'";
		}
		if(profissional.getCpf() != null && !profissional.getCpf().isEmpty()) {
			where += " and p.cpf = '" + profissional.getCpf() + "'";
		}
		if(profissional.getNumeroRegistro() > 0) {
			where += " and p.numeroRegistro = " + profissional.getNumeroRegistro();
		}
		
		return where;
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
