import core.Medico 
import groovy.util.GroovyTestCase;

/**
 * Testes de aceitacao da user story 15 (Controle de Medicos)
 */
class MedicoAcceptanceTests extends GroovyTestCase {
	void tearDown() {
		Medico.list()*.delete();
	}
	
	/**
	 * Teste de Aceitação 15.1: Cadastrar médico no sistema com todos os dados corretos (Operação Realizada com Sucesso).
	 */
	void test15_1() {
		def medicoValido = new Medico(
				username : 'renato',
				userRealName : 'renato',
				enabled : true,
				email : 'drrenato@gmail.com',
				passwd : 'drrenato',
				crm: '12441214',
				especialidade : 'Oftalmologista');
		assertTrue medicoValido.validate()
		medicoValido.save()
		assertNotNull Medico.findByUserRealName('renato')
	}
	
	/**
	 * Teste de Aceitação 15.2: Cadastrar médico no sistema com dados faltando (Operação Realizada sem Sucesso).
	 */
	void test15_2() {
		def medicoInvalido = new Medico(
				username : null, /* DADO FALTANDO */
				userRealName : 'renato',
				enabled : true,
				email : 'drrenato@gmail.com',
				passwd : 'drrenato',
				crm: '12441214',
				especialidade : 'Oftalmologista');
		assertFalse medicoInvalido.validate()
		medicoInvalido.save()
		assertNull Medico.findByUserRealName('renato')
	}
	
	/**
	 * Teste de Aceitação 15.3: Retirar médico existente da lista de médicos (Operação Realizada com Sucesso).
	 */
	void test15_3() {
		def medicoValido = new Medico(
				username : 'renato',
				userRealName : 'renato',
				enabled : true,
				email : 'drrenato@gmail.com',
				passwd : 'drrenato',
				crm: '12441214',
				especialidade : 'Oftalmologista');
		assertTrue medicoValido.validate()
		medicoValido.save()
		assertNotNull Medico.findByUserRealName('renato')
		medicoValido.delete()
		assertNull Medico.findByUserRealName('renato')
	}
	
	/**
	 * Teste de Aceitação 15.4: Retirar médico inexistente da lista de médico (Operação Realizada sem Sucesso).
	 */	
	void test15_4() {
		def instanciaValidaMasNaoSalva = new Medico(
				username : 'inst',
				userRealName : 'inst',
				enabled : true,
				email : '123@abc.com',
				passwd : '123',
				crm: '',
				especialidade : '');
		assertNull Medico.findByUserRealName('inst')
		instanciaValidaMasNaoSalva.delete()
		assertNull Medico.findByUserRealName('inst')
	}
	
	/**
	 * Teste de Aceitação 15.5: Consultar dados de médico existente no sistema (Operação Realizada com Sucesso).
	 */
	void test15_5() {
		def medicoValido = new Medico(
				username : 'renato',
				userRealName : 'renato',
				enabled : true,
				email : 'drrenato@gmail.com',
				passwd : 'drrenato',
				crm: '12441214',
				especialidade : 'Oftalmologista');
		medicoValido.save()
		assertNotNull Medico.findByUserRealName('renato')
		assertEquals 'renato', Medico.findByUserRealName('renato').getUsername()
		assertEquals 'renato', Medico.findByUserRealName('renato').getUserRealName()
		assertEquals true, Medico.findByUserRealName('renato').getEnabled()
		assertEquals 'drrenato', Medico.findByUserRealName('renato').getPasswd()
		assertEquals '12441214', Medico.findByUserRealName('renato').getCrm()
		assertEquals 'Oftalmologista', Medico.findByUserRealName('renato').getEspecialidade()
	}
	
	/**
	 * Teste de Aceitação 15.6: Consultar dados de médico inexistente no sistema (Operação Realizada sem Sucesso).
	 */
	void test15_6() {
		assertNull Medico.findByUserRealName('usuarioNaoCadastrado')
		try {
			assertEquals 'renato', Medico.findByUserRealName('usuarioNaoCadastrado').getUsername()
			assertEquals 'renato', Medico.findByUserRealName('usuarioNaoCadastrado').getUserRealName()
			assertEquals true, Medico.findByUserRealName('usuarioNaoCadastrado').getEnabled()
			assertEquals 'drrenato', Medico.findByUserRealName('usuarioNaoCadastrado').getPasswd()
			assertEquals '12441214', Medico.findByUserRealName('usuarioNaoCadastrado').getCrm()
			assertEquals 'Oftalmologista', Medico.findByUserRealName('usuarioNaoCadastrado').getEspecialidade()
			fail()
		} catch (Exception e) {
		}
	}
	
	/**
	 * Teste de Aceitação 15.7: Atualizar dados de médico existente no sistema (Operação Realizada com Sucesso).
	 */
	void test15_7() {
		def medicoValido = new Medico(
				username : 'renato',
				userRealName : 'renato',
				enabled : true,
				email : 'drrenato@gmail.com',
				passwd : 'drrenato',
				crm: '12441214',
				especialidade : 'Oftalmologista');
		medicoValido.save()
		
		assertNotNull Medico.findByUserRealName('renato')
		medicoValido.setUsername 'renatoaf'
		medicoValido.setPasswd 'novopass'
		medicoValido.setCrm '20202020'
		medicoValido.save()
		
		assertEquals 'renatoaf', Medico.findByUserRealName('renato').getUsername()
		assertEquals '20202020', Medico.findByUserRealName('renato').getCrm()
		assertEquals 'novopass', Medico.findByUserRealName('renato').getPasswd()
	}
	
	/**
	 * Teste de Aceitação 15.8: Atualizar dados de médico inexistente no sistema (Operação Realizada sem Sucesso).
	 */
	void test15_8() {
		def instanciaNaoExistente = Medico.findByUserRealName('inst')
		try {
			instanciaNaoExistente.setUsername 'novouser'
			instanciaNaoExistente.setPasswd 'novopass'
			instanciaNaoExistente.setCrm 'novocrm'
			instanciaNaoExistente.save()
			fail()
		} catch (Exception e) {
		}
	}
}
