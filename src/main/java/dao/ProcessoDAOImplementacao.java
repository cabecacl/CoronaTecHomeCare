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
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		
		tx.begin();
		
		Processo existe = ent.find(Processo.class, processo.getNome());
		
		if (existe != null) {
			existe.setDescricao(processo.getNome());
			
			ent.merge(processo);
			
			tx.commit();
			ent.close();
			return true;
		}else {
			return false;			
		}
		
	}

	@Override
	public boolean removerProcesso(Processo processo) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		
		Processo existe = ent.find(Processo.class, processo.getNome());
		
		tx.begin();
		
		if (!existe.equals("")) {
			ent.remove(existe);
			tx.commit();
			ent.close();
			return true;
		}else {
			return false;			
		}
	}

	@Override
	public Processo pesquisarProcesso(String name) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		
		Processo processo = null;
		
		tx.begin();
		
		Processo existe = ent.find(Processo.class, name);
		
		if (existe != null) {
			processo = existe;
		}
		
		return processo;
	}

	@Override
	public List<Processo> pesquisarProcesso(Processo processo) {
		
		return null;
	}

}
