package entidade;

import dao.PacienteDAO;
import dao.PacienteDAOImplementacao;
import dao.ProcessoDAO;
import dao.ProcessoDAOImplementacao;
import dao.ProfissionalDAO;
import dao.ProfissionalDAOImplementacao;

public class TesteConexao {

	public static void main(String[] args) {
		
//		EntityManager ent = JpaUtil.getEntityManager();
//		EntityTransaction t = ent.getTransaction();
//		t.begin();
//		
//		Profissional p = new Profissional();
//		p.setCpf("12345");
//		p.setNome("Henrique o ...");
//		p.setNumeroRegistro(24);
//		p.setArea("Cirurgião Plastico");
//		p.setEmail("henrique@henrycristo.com");
//		p.setTelefone("5555-9999");
//		p.setTipoProfissional("Outros");
//		p.setSenha("12345");
//		
//		ent.persist(p);
//		
//		t.commit();
//		ent.close();
		
		ProcessoDAO pdao = new ProcessoDAOImplementacao();
		System.out.println(pdao.listarProcessos());
		
		ProfissionalDAO profdao = new ProfissionalDAOImplementacao();
		System.out.println(profdao.listarProfissionais());
		
		PacienteDAO pacdao = new PacienteDAOImplementacao();
		System.out.println(pacdao.listarPacientes());

	}

}
