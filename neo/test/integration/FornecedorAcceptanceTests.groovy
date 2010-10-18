import core.Fornecedor;
import groovy.util.GroovyTestCase;

/**
 * Testes de aceitacao da user story 8 (Controle de Fornecedores)
 */
class FornecedorAcceptanceTests extends GroovyTestCase  {
	void tearDown() {
		Fornecedor.list()*.delete();
	}
	
	/**
	 * Teste de Aceitação 8.1: Cadastrar fornecedor no sistema com todos os dados corretos (Operação Realizada com Sucesso).
	 */
	void test8_1() {
		def fornecedorValido = new Fornecedor(
				cnpj : '1234567890',
				nome : 'OticaACT',
				endereco : 'Rua Maciel Pinheiro 255, Centro',
				telefone : '34411312');
		assertTrue fornecedorValido.validate()
		fornecedorValido.save()
		assertNotNull Fornecedor.findByNome('OticaACT')
	}
	
	/**
	 * Teste de Aceitação 8.2: Cadastrar fornecedor no sistema com dados faltando (Operação Realizada sem Sucesso).
	 */
	void test8_2() {
		def fornecedorInvalido = new Fornecedor(
				cnpj : '123456789124124124124124124120', /* DADO INVALIDO, ACIMA DO LIMITE */
				nome : null, /* DADO FALTANDO */
				endereco : 'Rua Maciel Pinheiro 255, Centro',
				telefone : '34411312');
		assertFalse fornecedorInvalido.validate()
		fornecedorInvalido.save()
		assertNull Fornecedor.findByNome('OticaACT')
	}
	
	/**
	 * Teste de Aceitação 8.3: Retirar fornecedor existente da lista dos fornecedores (Operação Realizada com Sucesso).
	 */
	void test8_3() {
		def fornecedorValido = new Fornecedor(
				cnpj : '1234567890',
				nome : 'OticaACT',
				endereco : 'Rua Maciel Pinheiro 255, Centro',
				telefone : '34411312');
		assertTrue fornecedorValido.validate()
		fornecedorValido.save()
		assertNotNull Fornecedor.findByNome('OticaACT')
		fornecedorValido.delete()
		assertNull Fornecedor.findByNome('OticaACT')
	}
	
	/**
	 * Teste de Aceitação 8.4: Retirar fornecedor inexistente da lista dos fornecedores (Operação Realizada sem Sucesso).
	 */
	void test8_4() {
		def fornecedorValidoMasNaoSalvo = new Fornecedor(
				cnpj : '47518213313',
				nome : 'ValidoMasNaoSalvo',
				endereco : 'Rua Maciel Pinheiro 255, Centro',
				telefone : '34411312');
		assertNull Fornecedor.findByNome('ValidoMasNaoSalvo')
		fornecedorValidoMasNaoSalvo.delete()
		assertNull Fornecedor.findByNome('ValidoMasNaoSalvo')
	}
	
	/**
	 * Teste de Aceitação 8.5: Consultar dados de fornecedor existente no sistema (Operação Realizada com Sucesso).
	 */
	void test8_5() {
		def fornecedorValido = new Fornecedor(
				cnpj : '1234567890',
				nome : 'OticaACT',
				endereco : 'Rua Maciel Pinheiro 255, Centro',
				telefone : '34411312');
		fornecedorValido.save()
		assertNotNull Fornecedor.findByNome('OticaACT')
		assertEquals 'OticaACT', Fornecedor.findByNome('OticaACT').getNome()
		assertEquals 'Rua Maciel Pinheiro 255, Centro', Fornecedor.findByNome('OticaACT').getEndereco()
		assertEquals '34411312', Fornecedor.findByNome('OticaACT').getTelefone()
		assertEquals '1234567890', Fornecedor.findByNome('OticaACT').getCnpj()
	}
	
	/**
	 * Teste de Aceitação 8.6: Consultar dados de fornecedor inexistente no sistema (Operação Realizada sem Sucesso).
	 */
	void test8_6() {
		assertNull Fornecedor.findByNome('FornecedorNaoCadastrado')
		try {
			assertEquals 'FornecedorNaoCadastrado', Fornecedor.findByNome('FornecedorNaoCadastrado').getNome()
			assertEquals 'Rua dos Fornecedores Inexistentes', Fornecedor.findByNome('FornecedorNaoCadastrado').getEndereco()
			fail()
		} catch (Exception e) {
		}
	}
	
	/**
	 * Teste de Aceitação 8.7: Atualizar dados de fornecedor existente no sistema (Operação Realizada com Sucesso).
	 */
	void test8_7() {
		def fornecedorValido = new Fornecedor(
				cnpj : '1234567890',
				nome : 'OticaACT',
				endereco : 'Rua Maciel Pinheiro 255, Centro',
				telefone : '34411312');
		fornecedorValido.save()
		
		assertNotNull Fornecedor.findByNome('OticaACT')
		fornecedorValido.setCnpj '412412141'
		fornecedorValido.setEndereco 'Rua Bla Bla Bla'
		fornecedorValido.save()
		
		assertEquals '412412141', Fornecedor.findByNome('OticaACT').getCnpj()
		assertEquals 'Rua Bla Bla Bla', Fornecedor.findByNome('OticaACT').getEndereco()
	}
	
	/**
	 * Teste de Aceitação 8.8: Atualizar dados de fornecedor inexistente no sistema (Operação Realizada sem Sucesso). 
	 */
	void test8_8() {
		def instanciaNaoExistente = Fornecedor.findByNome('FornecedorNaoExistente')
		try {
			instanciaNaoExistente.setEndereco 'Rua dos Inexistentes'
			instanciaNaoExistente.setTelefone '33391241'
			fail()
		} catch (Exception e) {
		}
	}
}
