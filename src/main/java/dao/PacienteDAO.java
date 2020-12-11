package dao;

import java.util.List;

import entidade.Paciente;

public interface PacienteDAO {
	
	public boolean inserirPaciente(Paciente paciente);
	
	public boolean alterarPaciente(Paciente paciente);
	
	public boolean removerPaciente(Paciente paciente);
	
	public Paciente pesquisarPaciente(String cpf);
	
	public List<Paciente> pesquisarPaciente(Paciente paciente);
	
	public List<Paciente> listarPacientes();

}
