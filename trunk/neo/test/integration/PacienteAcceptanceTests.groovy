import java.text.SimpleDateFormat;

import core.Paciente 
import core.Sexo 
import groovy.util.GroovyTestCase;

/**
 * Testes de aceitacao da user story 5 (Implementar funcionalidade de controle de pacientes)
 */
class PacienteAcceptanceTests extends GroovyTestCase {
	
	void tearDown() {
		Paciente.list()*.delete();
	}
	
	/**
	 * Teste de Aceitação 5.1: Cadastrar um cliente com todos os dados corretos.
	 */
	void test5_1() {
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
		assertNotNull Paciente.findByNome('Fabio')
		assertNotNull Paciente.findByNome('Fabio de Sousa')
		assertNotNull Paciente.findByNome('Solon')
		assertNotNull Paciente.findByNome('Jose')
	}
	
	/**
	 * Teste de Aceitação 5.2: Cadastrar um cliente com dados obrigatórios faltando (Cadastro não Realizado).
	 */
	void test5_2() {
		def dataAgora = new Date()
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		def futuro = formato.parse("01/10/2011")
		def p = new Paciente(nome: 'Jose', nascimento: dataAgora)
		def p2 = new Paciente(sexo: Sexo.FEMININO, nascimento: dataAgora)
		def p3 = new Paciente(nome: 'Fabio de Sousa', sexo: Sexo.MASCULINO, nascimento: futuro)
		assertFalse p.validate()
		p.save()
		assertFalse p2.validate()
		p2.save()
		assertFalse p3.validate()
		p3.save()
		assertNull Paciente.findByNome('Jose')
		assertNull Paciente.findByNome('Fabio de Sousa')
		assertNull Paciente.findBySexo(Sexo.MASCULINO)
	}
	
	/**
	 * Teste de Aceitação 5.3: Retirar paciente existente da lista dos pacientes (Operação Realizada com Sucesso).
	 */
	void test5_3(){
		def dataAgora = new Date()
		def p = new Paciente(nome: 'Jose', sexo: Sexo.MASCULINO, nascimento: dataAgora)
		def p2 = new Paciente(nome: 'Fabio', sexo: Sexo.FEMININO, nascimento: dataAgora)
		assertTrue p.validate()
		p.save()
		assertTrue p2.validate()
		p2.save()
		def medicoUm = Paciente.findByNome('Fabio')
		assertNotNull medicoUm
		def medicoDois = Paciente.findByNome('Jose')
		assertNotNull medicoDois
		medicoUm.delete()
		medicoDois.delete()
		assertNull Paciente.findByNome('Fabio')
		assertNull Paciente.findByNome('Jose')
	}
	
	/**
	 * Teste de Aceitação 5.4: Retirar paciente inexistente da lista dos pacientes (Operação Realizada sem Sucesso).
	 */
	void test5_4(){
		def dataAgora = new Date()
		def p = new Paciente(nome: 'Jose', sexo: Sexo.MASCULINO, nascimento: dataAgora)
		assertTrue p.validate()
		assertNull Paciente.findByNome('Jose')
		p.delete()
		assertNull Paciente.findByNome('Jose')
	}
	
	/**
	 * Teste de Aceitação 5.5: Atualizar dados de paciente existente no sistema (Operação Realizada com Sucesso).
	 */
	void test5_5(){
		def dataAgora = new Date()
		def p = new Paciente(nome: 'Jose', sexo: Sexo.MASCULINO, nascimento: dataAgora)
		def p2 = new Paciente(nome: 'Fabio', sexo: Sexo.FEMININO, nascimento: dataAgora)
		assertTrue p.validate()
		p.save()
		assertTrue p2.validate()
		p2.save()
		assertNotNull Paciente.findByNome('Fabio')
		assertNotNull Paciente.findByNome('Jose')
		
		def instUm = Paciente.findByNome('Jose')
		instUm.setNome 'Marcos'
		assertTrue instUm.validate()
		instUm.save()
		
		assertNotNull Paciente.findByNome('Marcos')
		assertNull Paciente.findByNome('Jose')
		
		assertEquals 'Marcos', Paciente.findBySexo(Sexo.MASCULINO).getNome()
		
		def instDois = Paciente.findByNome('Fabio')
		instDois.setSexo Sexo.MASCULINO
		assertTrue instDois.validate()
		instDois.save()
		
		def lista = Paciente.findBySexo(Sexo.MASCULINO).list()
		assertNotNull lista
		assertEquals 2, lista.size()
		assertNull Paciente.findBySexo(Sexo.FEMININO)
	}
	
	/**
	* Teste de Aceitação 5.6: Atualizar dados de paciente inexistente no sistema (Operação Realizada sem Sucesso).
	*/
	void test5_6(){
		def instanciaNaoExistente = Paciente.findByNome('Marcos')
		try {
			instanciaNaoExistente.setNome 'Renato'
			instanciaNaoExistente.setSexo Sexo.FEMININO
			instanciaNaoExistente.setNascimento new Date()
			instanciaNaoExistente.save()
			fail()
		} catch (Exception e) {
		}
	}
}
