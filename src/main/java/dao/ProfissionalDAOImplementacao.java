package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
		
		return false;
	}

	@Override
	public boolean removerProfissional(Profissional profissional) {
		
		return false;
	}

	@Override
	public Profissional pesquisarProfissional(int id) {
		
		return null;
	}

	@Override
	public List<Profissional> pesquisarProfissional(Profissional profissional) {
		
		return null;
	}

}
