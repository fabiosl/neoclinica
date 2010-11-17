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
		
		def novoMedicoValido = new Medico(
				username : 'solon',
				userRealName : 'Solon Aguiar',
				enabled : true,
				email : 'solon@facebook.com',
				passwd : 'drsolon',
				crm: '4242424242',
				especialidade : 'Cirurgia');
		assertTrue novoMedicoValido.validate()
		novoMedicoValido.save()
		assertNotNull Medico.findByUserRealName('Solon Aguiar')
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
		
		def outroMedicoValido = new Medico(
				username : 'fabio',
				userRealName : 'Fabio Leal',
				enabled : true,
				email : 'fabio@zehmane.com',
				passwd : 'lealzinho',
				crm: null,
				especialidade : 'Psicologia');
		assertFalse outroMedicoValido.validate()
		outroMedicoValido.save()
		assertNull Medico.findByUserRealName('Fabio Leal')
		
		def maisOutroMedicoValido = new Medico(
				username : 'joaquim',
				userRealName : 'Joaquim Grava',
				enabled : true,
				email : 'quimquim@timao.com',
				passwd : 'timao',
				crm: '12345677',
				especialidade : null);
		assertFalse maisOutroMedicoValido.validate()
		maisOutroMedicoValido.save()
		assertNull Medico.findByUserRealName('Joaquim Grava')
		
		def maisUmOutroMedicoValido = new Medico(
				username : null,
				userRealName : 'Carlinhos',
				enabled : true,
				email : 'linhos@bambi.com',
				passwd : 'saopaulofc',
				crm: '128313414',
				especialidade : 'Obstetricia');
		assertFalse maisUmOutroMedicoValido.validate()
		maisUmOutroMedicoValido.save()
		assertNull Medico.findByUserRealName('Carlinhos')
		
		def maisUmMedicoValido = new Medico(
				username : 'fenix',
				userRealName : 'Shaquille Oneal',
				enabled : true,
				email : 'shaq@phoenix.com',
				passwd : null,
				crm: '1920141241',
				especialidade : 'Neurologia');
		assertFalse maisUmMedicoValido.validate()
		maisUmMedicoValido.save()
		assertNull Medico.findByUserRealName('Shaquille Oneal')
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
		
		def novoMedicoValido = new Medico(
				username : 'solon',
				userRealName : 'Solon Aguiar',
				enabled : true,
				email : 'solon@facebook.com',
				passwd : 'drsolon',
				crm: '4242424242',
				especialidade : 'Cirurgia');
		assertTrue novoMedicoValido.validate()
		novoMedicoValido.save()
		assertNotNull Medico.findByUserRealName('Solon Aguiar')
		novoMedicoValido.delete()
		assertNull Medico.findByUserRealName('solon')
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
		
		assertEquals 'renato', Medico.findByEmail('drrenato@gmail.com').getUsername()
		assertEquals 'renato', Medico.findByEmail('drrenato@gmail.com').getUserRealName()
		assertEquals true, Medico.findByEmail('drrenato@gmail.com').getEnabled()
		assertEquals 'drrenato', Medico.findByEmail('drrenato@gmail.com').getPasswd()
		assertEquals '12441214', Medico.findByEmail('drrenato@gmail.com').getCrm()
		assertEquals 'Oftalmologista', Medico.findByEmail('drrenato@gmail.com').getEspecialidade()
		
		assertEquals 'renato', Medico.findByEspecialidade('Oftalmologista').getUsername()
		assertEquals 'renato', Medico.findByEspecialidade('Oftalmologista').getUserRealName()
		assertEquals true, Medico.findByEspecialidade('Oftalmologista').getEnabled()
		assertEquals 'drrenato', Medico.findByEspecialidade('Oftalmologista').getPasswd()
		assertEquals '12441214', Medico.findByEspecialidade('Oftalmologista').getCrm()
		assertEquals 'Oftalmologista', Medico.findByEspecialidade('Oftalmologista').getEspecialidade()
		
		def novoMedicoValido = new Medico(
				username : 'solon',
				userRealName : 'Solon Aguiar',
				enabled : true,
				email : 'solon@facebook.com',
				passwd : 'drsolon',
				crm: '4242424242',
				especialidade : 'Cirurgia');
		assertTrue novoMedicoValido.validate()
		novoMedicoValido.save()
		assertEquals 'solon', Medico.findByUserRealName('Solon Aguiar').getUsername()
		assertEquals 'Solon Aguiar', Medico.findByUserRealName('Solon Aguiar').getUserRealName()
		assertEquals true, Medico.findByUserRealName('Solon Aguiar').getEnabled()
		assertEquals 'drsolon', Medico.findByUserRealName('Solon Aguiar').getPasswd()
		assertEquals '4242424242', Medico.findByUserRealName('Solon Aguiar').getCrm()
		assertEquals 'Cirurgia', Medico.findByUserRealName('Solon Aguiar').getEspecialidade()
		
		assertEquals 'solon', Medico.findByUsername('solon').getUsername()
		assertEquals 'Solon Aguiar', Medico.findByUsername('solon').getUserRealName()
		assertEquals true, Medico.findByUsername('solon').getEnabled()
		assertEquals 'drsolon', Medico.findByUsername('solon').getPasswd()
		assertEquals '4242424242', Medico.findByUsername('solon').getCrm()
		assertEquals 'Cirurgia', Medico.findByUsername('solon').getEspecialidade()
		
		assertEquals 'solon', Medico.findByCrm('4242424242').getUsername()
		assertEquals 'Solon Aguiar', Medico.findByCrm('4242424242').getUserRealName()
		assertEquals true, Medico.findByCrm('4242424242').getEnabled()
		assertEquals 'drsolon', Medico.findByCrm('4242424242').getPasswd()
		assertEquals '4242424242', Medico.findByCrm('4242424242').getCrm()
		assertEquals 'Cirurgia', Medico.findByCrm('4242424242').getEspecialidade()
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
		assertEquals 'Oftalmologista', Medico.findByUserRealName('renato').getEspecialidade()
		
		def novoMedicoValido = new Medico(
				username : 'solon',
				userRealName : 'Solon Aguiar',
				enabled : true,
				email : 'solon@facebook.com',
				passwd : 'drsolon',
				crm: '4242424242',
				especialidade : 'Cirurgia');
		assertTrue novoMedicoValido.validate()
		novoMedicoValido.save()
		assertNotNull Medico.findByUsername('solon')
		
		novoMedicoValido.setUsername 'solonAguiar'
		novoMedicoValido.setPasswd 'melhormedico'
		novoMedicoValido.setCrm '2345678'
		novoMedicoValido.setEspecialidade 'Clinico Geral'
		novoMedicoValido.save()
		
		assertEquals 'solonAguiar', Medico.findByUserRealName('Solon Aguiar').getUsername()
		assertEquals '2345678', Medico.findByUserRealName('Solon Aguiar').getCrm()
		assertEquals 'melhormedico', Medico.findByUserRealName('Solon Aguiar').getPasswd()
		assertEquals 'Clinico Geral', Medico.findByUserRealName('Solon Aguiar').getEspecialidade()
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
