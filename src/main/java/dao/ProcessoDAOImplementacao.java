package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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
		} else {
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
		} else {
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

	@Override
	public List<Processo> listarProcessos() {
		
		String sql = "from Processo p";

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);

		List<Processo> listaProcessos = query.getResultList();

		ent.close();

		return listaProcessos;
	}

}
