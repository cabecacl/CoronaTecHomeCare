package dao;

import java.util.Date;
import java.util.List;

import entidade.Atendimento;

public interface AtendimentoDAO {
	
	public boolean inserirAtendimento(Atendimento atendimento);
	
	public boolean alterarAtendimento(Atendimento atendimento);
	
	public boolean removerAtendimento(Atendimento atendimento);
	
	public Atendimento pesquisarAtendimento(int id);
	
	public List<Atendimento> pesquisarAtendimento(Atendimento atendimento, Date dtainicio, Date dtafim);

}
