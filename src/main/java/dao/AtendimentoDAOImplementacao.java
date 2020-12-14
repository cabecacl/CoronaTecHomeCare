package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.Atendimento;
import util.JpaUtil;

public class AtendimentoDAOImplementacao implements AtendimentoDAO {

	@Override
	public boolean inserirAtendimento(Atendimento atendimento) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		ent.merge(atendimento);

		tx.commit();
		ent.close();

		return true;
	}

	@Override
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

			tx.commit();
			ent.merge(atendimento);
			ent.close();

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removerAtendimento(Atendimento atendimento) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		Atendimento existe = ent.find(Atendimento.class, atendimento.getIdatendimento());

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
	public Atendimento pesquisarAtendimento(int id) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		Atendimento atendimento = null;

		tx.begin();

		Atendimento existe = ent.find(Atendimento.class, id);

		if (existe != null) {
			atendimento = existe;
		}

		return atendimento;
	}

	@Override
	public List<Atendimento> pesquisarAtendimento(Atendimento atendimento,Date dtainicio, Date dtafim) {

		String sql = "from atendimento p where 1=1 " + montarWhere(atendimento) + retornaFiltroData(dtainicio, dtafim);
		return null;
	}

	// String montarWhere
	private String montarWhere(Atendimento atendimento) {
	String where = " ";

	if (atendimento.getIdatendimento() > 0) {
		where += " and a.idatendimento = '" + atendimento.getIdatendimento() + "'";
	} else {
		if (atendimento.getProficional() != null && atendimento.getProficional().getId() > 0) {
			where += " and a.proficional.id = " + atendimento.getProficional().getId() ;
			}
		if (atendimento.getPaciente() != null && atendimento.getPaciente().getIdpaciente() > 0) {
			where += " and a.paciente.idpaciente = " + atendimento.getPaciente().getIdpaciente();
			}
		if (atendimento.getCid() != null && atendimento.getCid().isEmpty()) {
			where += " and a.Cid = " + atendimento.getCid();
			}
		if (atendimento.getProcesso() != null && atendimento.getProcesso().getNome().isEmpty()) {
			where += " and a.processo = " + atendimento.getProcesso();
			}
	}
	return where;
}

	private String retornaFiltroData(Date dtainicio, Date dtafim) {
		String filtroData = " ";
		SimpleDateFormat fdtainicio = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat fdtafim = new SimpleDateFormat("dd-MM-yyyy");
		if(dtainicio != null && dtafim != null){
		    filtroData += " and a.dta between  TO_DATE('" + fdtainicio.format(dtainicio) + "', 'DD/MM/YYYY') and "
											 + " TO_DATE('" + fdtafim.format(dtafim) + "', 'DD/MM/YYYY') ";
		}
		return filtroData;
	}
	
	
}
