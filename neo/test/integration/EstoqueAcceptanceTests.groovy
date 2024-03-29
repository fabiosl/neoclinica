import core.Lente;
import groovy.util.GroovyTestCase;

/**
 * Testes de aceitacao da user story 7 (Controle de Estoque)
 */
class EstoqueAcceptanceTests extends GroovyTestCase {
	void tearDown() {
		Lente.list()*.delete();
	}
	
	/**
	 * Teste de Aceitação 7.1: Cadastrar novo tipo de lente com todos os dados corretos (Operação Realizada com Sucesso).
	 */
	void test7_1() {
		def lenteValida = new Lente(
				tipo : 'Look',
				quantidade : 15,
				valor : 0f);
		assertTrue lenteValida.validate()
		lenteValida.save()
		assertNotNull Lente.findByTipo('Look')
		
		def novaLenteValida = new Lente(
				tipo : 'RayBan',
				quantidade : 389,
				valor : 89.9f);
		assertTrue novaLenteValida.validate()
		novaLenteValida.save()
		assertNotNull Lente.findByTipo('Look')
		assertNotNull Lente.findByTipo('RayBan')
		assertNotNull Lente.findByValor(89.9f)
		
		//Duas lentes no banco
		assertEquals 2, Lente.list().size()
	}
	
	/**
	 * Teste de Aceitação 7.2: Cadastrar novo tipo de lente com dados faltando (Operação Realizada sem Sucesso).
	 */
	void test7_2() {
		def lenteInvalida = new Lente(
				tipo : null, /* DADO FALTANDO */
				quantidade : -1, /* DADO INVALIDO */
				valor : 0f);
		assertFalse lenteInvalida.validate()
		lenteInvalida.save()
		assertNull Lente.findByTipo('Look')
		
		def novaLenteInvalida = new Lente(
				tipo : 'RayBan',
				quantidade : -1, /* DADO INVALIDO */
				valor : 0f);
		assertFalse novaLenteInvalida.validate()
		novaLenteInvalida.save()
		assertNull Lente.findByTipo('RayBan')
		
		def maisUmaLenteInvalida = new Lente(
				tipo : null, /* DADO FALTANDO */
				quantidade : 10,
				valor : 0f);
		assertFalse maisUmaLenteInvalida.validate()
		maisUmaLenteInvalida.save()
		assertNull Lente.findByQuantidade(10)
		
		def outraLenteInvalida = new Lente(
				tipo : 'RayBan',
				quantidade : 10,
				valor : -2.0f); /* DADO INVALIDO */
		assertFalse outraLenteInvalida.validate()
		outraLenteInvalida.save()
		assertNull Lente.findByQuantidade(10)
	}
	
	/**
	 * Teste de Aceitação 7.3: Remover tipo de lente existente no sistema (Operação Realizada com Sucesso).
	 */
	void test7_3() {
		def lenteValida = new Lente(
				tipo : 'Look',
				quantidade : 15,
				valor : 0f);
			
		assertTrue lenteValida.validate()
		lenteValida.save()
		assertEquals 1, Lente.list().size()
		assertNotNull Lente.findByTipo('Look')
		lenteValida.delete()
		assertNull Lente.findByTipo('Look')
		
		assertEquals 0, Lente.list().size()
		def novaLenteValida = new Lente(
				tipo : 'RayBan',
				quantidade : 389,
				valor : 89.9f);
		assertTrue novaLenteValida.validate()
		novaLenteValida.save()
		assertEquals 1, Lente.list().size()
		assertNotNull Lente.findByTipo('RayBan')
		assertNotNull Lente.findByValor(89.9f)
		novaLenteValida.delete()
		assertNull Lente.findByTipo('RayBan')
		assertNull Lente.findByValor(89.9f)
		
		assertEquals 0, Lente.list().size()
	}
	
	/**
	 * Teste de Aceitação 7.4: Remover tipo de lente inexistente no sistema (Operação Realizada sem Sucesso).
	 */
	void test7_4() {
		def instanciaValidaMasNaoSalva = new Lente(
				tipo : 'ValidaMasNaoSalva',
				quantidade : 15,
				valor : 0f)
		assertNull Lente.findByTipo('ValidaMasNaoSalva')
		instanciaValidaMasNaoSalva.delete()
		assertNull Lente.findByTipo('ValidaMasNaoSalva')
	}
	
	/**
	 * Teste de Aceitação 7.5: Consultar quantidade de lentes de um certo tipo (existente no sistema) disponíveis (Operação Realizada com Sucesso).
	 */
	void test7_5() {
		def lenteValida = new Lente(
				tipo : 'Look',
				quantidade : 15,
				valor : 0f);
		lenteValida.save()
		assertNotNull Lente.findByTipo('Look')
		assertEquals 'Look', Lente.findByTipo('Look').getTipo()
		assertEquals 0f, Lente.findByTipo('Look').getValor()
		assertEquals 15, Lente.findByTipo('Look').getQuantidade()
		
		def novaLenteValida = new Lente(
			tipo : 'RayBan',
			quantidade : 389,
			valor : 89.9f);
		assertTrue novaLenteValida.validate()
		novaLenteValida.save()
		assertNotNull Lente.findByTipo('RayBan')
		assertNotNull Lente.findByValor(89.9f)
		assertEquals 'RayBan', Lente.findByTipo('RayBan').getTipo()
		assertEquals 89.9f, Lente.findByTipo('RayBan').getValor()
		assertEquals 389, Lente.findByTipo('RayBan').getQuantidade()
	}
	
	/**
	 * Teste de Aceitação 7.6: Consultar quantidade de lentes de um certo tipo (inexistente no sistema) disponíveis (Operação Realizada com Sucesso).
	 */
	void test7_6() {
		assertNull Lente.findByTipo('LenteNaoCadastrada')
		try {
			assertEquals 'LenteNaoCadastrada', Lente.findByTipo('LenteNaoCadastrada').getTipo()
			assertEquals 2f, Lente.findByTipo('LenteNaoCadastrada').getValor()
			assertEquals 24, Lente.findByTipo('LenteNaoCadastrada').getQuantidade()
			fail()
		} catch (Exception e) {
		}
	}
	
	/**
	 * Teste de Aceitação 7.7: Modificar a quantidade de lentes de um certo tipo (existente no sistema) disponíveis (Operação Realizada com Sucesso).
	 */
	void test7_7() {
		def lenteValida = new Lente(
				tipo : 'Look',
				quantidade : 15,
				valor : 0f);
		lenteValida.save()
		
		assertNotNull Lente.findByTipo('Look')
		assertEquals 15, Lente.findByTipo('Look').getQuantidade()
		lenteValida.setQuantidade 31
		lenteValida.save()
		
		assertEquals 31, Lente.findByTipo('Look').getQuantidade()
		
		def novaLenteValida = new Lente(
			tipo : 'RayBan',
			quantidade : 389,
			valor : 89.9f);
		assertTrue novaLenteValida.validate()
		novaLenteValida.save()
		assertNotNull Lente.findByTipo('RayBan')
		assertEquals 389, Lente.findByTipo('RayBan').getQuantidade()
		novaLenteValida.setQuantidade 10
		novaLenteValida.save()
	}
	
	/**
	 * Teste de Aceitação 7.8: Modificar a quantidade de lentes de um certo tipo (inexistente no sistema) disponíveis (Operação Realizada sem Sucesso). 
	 */
	void test7_8() {
		def instanciaNaoExistente = Lente.findByTipo('LenteNaoExistente')
		try {
			instanciaNaoExistente.setQuantidade 31
			instanciaNaoExistente.setValor 39.25
			fail()
		} catch (Exception e) {
		}
	}
}
