
import acesso.Hierarquia;
import core.FormaDePagamento 
import core.Medico 
import core.Paciente 
import core.Pagamento 
import core.ProcedimentoMedico 
import core.Sexo;
import core.TipoProcedimentoMedico 
import groovy.util.GroovyTestCase;

/**
 * Testes de aceitacao da user story 13 (Implementar funcionalidade de relatório de paciente)
 */
class BuscaPacienteAcceptanceTests extends GroovyTestCase {
	void tearDown() {
		Paciente.list()*.delete();
	}
	
	/**
	 * Teste de Aceitação 13.1: Pesquisar dados de paciente existente no sistema.
	 */
	void test13_1() {
		def dataAgora = new Date()
		def p = new Paciente(nome: 'Jose', sexo: Sexo.MASCULINO, nascimento: dataAgora)
		def p2 = new Paciente(nome: 'Fabio', sexo: Sexo.FEMININO, nascimento: dataAgora)
		def p3 = new Paciente(nome: 'Fabio de Sousa', sexo: Sexo.MASCULINO, nascimento: dataAgora)
		def p4 = new Paciente(nome: 'Solon', sexo: Sexo.MASCULINO, nascimento: dataAgora)
		assertTrue p.validate()
		p.save()
		assertTrue p2.validate()
		p2.save()
		assertTrue p3.validate()
		p3.save()
		assertTrue p4.validate()
		p4.save()
		
		//Mesma busca que eh feita na controladora
		def nome = 'Jose'
		def criterioBusca = "%" + nome + "%"
		def pacientes = Paciente.createCriteria().list() { like("nome", criterioBusca) }
		assertTrue pacientes.size() != 0
		assertTrue pacientes.size() == 1
		
		def novoNome = 'Fabio'
		def novoCriterioBusca = "%" + novoNome + "%"
		def novosPacientes = Paciente.createCriteria().list() { like("nome", novoCriterioBusca) }
		assertTrue novosPacientes.size() != 0
		assertTrue novosPacientes.size() == 2
		
		def newNome = 'Solon'
		def newCriterioBusca = "%" + newNome + "%"
		def newPacientes = Paciente.createCriteria().list() { like("nome", newCriterioBusca) }
		assertTrue newPacientes.size() != 0
		assertTrue newPacientes.size() == 1
	}
	
	/**
	 * Teste de Aceitação 13.2: Pesquisar dados de paciente inexistente no sistema.
	 */
	void test13_2() {
		def dataAgora = new Date()
		def p = new Paciente(nome: 'Jose', sexo: Sexo.MASCULINO, nascimento: dataAgora)
		def p2 = new Paciente(nome: 'Fabio', sexo: Sexo.FEMININO, nascimento: dataAgora)
		def p3 = new Paciente(nome: 'Fabio de Sousa', sexo: Sexo.MASCULINO, nascimento: dataAgora)
		def p4 = new Paciente(nome: 'Solon', sexo: Sexo.MASCULINO, nascimento: dataAgora)
		assertTrue p.validate()
		p.save()
		assertTrue p2.validate()
		p2.save()
		assertTrue p3.validate()
		p3.save()
		assertTrue p4.validate()
		p4.save()
		
		def nome = 'Joaquim'
		def criterioBusca = "%" + nome + "%"
		def pacientes = Paciente.createCriteria().list() { like("nome", criterioBusca) }
		assertTrue pacientes.size() == 0
	}
}
