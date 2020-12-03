package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.Processo;
import util.JpaUtil;

public class ProcessoDAOImplementacao implements ProcessoDAO {

	@Override
	public boolean inserirProcesso(Processo processo) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		
		tx.begin();
		
		ent.merge(processo);
		
		tx.commit();
		ent.close();
		
		return true;
	}

	@Override
	public boolean alterarProcesso(Processo processo) {
		
		return false;
	}

	@Override
	public boolean removerProcesso(Processo processo) {
		
		return false;
	}

	@Override
	public Processo pesquisarProcesso(String name) {
		
		return null;
	}

	@Override
	public List<Processo> pesquisarProcesso(Processo processo) {
		
		return null;
	}

}
