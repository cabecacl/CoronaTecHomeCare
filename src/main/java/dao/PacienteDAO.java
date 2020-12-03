package dao;

import java.util.List;

import entidade.Paciente;

public interface PacienteDAO {
	
	public boolean inserirPaciente(Paciente paciente);
	
	public boolean alterarPaciente(Paciente paciente);
	
	public boolean removerPaciente(Paciente paciente);
	
	public Paciente pesquisarPaciente(int id);
	
	public List<Paciente> pesquisarPaciente(Paciente paciente);

}
