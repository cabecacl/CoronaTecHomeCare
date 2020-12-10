package dao;

import java.util.List;

import entidade.Processo;

public interface ProcessoDAO {
	
	public boolean inserirProcesso(Processo processo);
	
	public boolean alterarProcesso(Processo processo);
	
	public boolean removerProcesso(Processo processo);
	
	public Processo pesquisarProcesso(String name);
	
	public List<Processo> pesquisarProcesso(Processo processo);
	
	public List<Processo> listarProcessos();

}
