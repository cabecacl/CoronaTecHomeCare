package dao;

import java.util.List;

import entidade.Profissional;

public interface ProfissionalDAO {
	
	public boolean inserirProfissional(Profissional profissional);
	
	public boolean alterarProfissional(Profissional profissional);
	
	public boolean removerProfissional(Profissional profissional);
	
	public Profissional pesquisarProfissional(int id);
	
	public List<Profissional> pesquisarProfissional(Profissional profissional);

}
