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
		assertEquals 0, Fornecedor.list().size()
		def fornecedorValido = new Fornecedor(
				cnpj : '1234567890',
				nome : 'OticaACT',
				endereco : 'Rua Maciel Pinheiro 255, Centro',
				telefone : '34411312');
		assertTrue fornecedorValido.validate()
		fornecedorValido.save()
		assertNotNull Fornecedor.findByNome('OticaACT')
		assertEquals 1, Fornecedor.list().size()
		
		def novoFornecedorValido = new Fornecedor(
				cnpj : '98765312',
				nome : 'Paraiso das lentes',
				endereco : 'Rua Miguel Couto, Catole',
				telefone : '0800072679');
		assertTrue novoFornecedorValido.validate()
		novoFornecedorValido.save()
		assertNotNull Fornecedor.findByNome('Paraiso das lentes')
		assertEquals 2, Fornecedor.list().size()
		
		def outroFornecedorValido = new Fornecedor(
				cnpj : null,
				nome : 'Otica diniz',
				endereco : 'Rua do pelourinho, Pelourinho',
				telefone : null);
		assertTrue outroFornecedorValido.validate()
		outroFornecedorValido.save()
		assertNotNull Fornecedor.findByNome('Otica diniz')
		assertEquals 3, Fornecedor.list().size()
	}
	
	/**
	 * Teste de Aceitação 8.2: Cadastrar fornecedor no sistema com dados faltando (Operação Realizada sem Sucesso).
	 */
	void test8_2() {
		assertEquals 0, Fornecedor.list().size()
		def fornecedorInvalido = new Fornecedor(
				cnpj : '123456789124124124124124124120', /* DADO INVALIDO, ACIMA DO LIMITE */
				nome : null, /* DADO FALTANDO */
				endereco : 'Rua Maciel Pinheiro 255, Centro',
				telefone : '34411312');
		assertFalse fornecedorInvalido.validate()
		fornecedorInvalido.save()
		assertNull Fornecedor.findByNome('OticaACT')
		assertEquals 0, Fornecedor.list().size()
		
		def outroFornecedorInvalido = new Fornecedor(
				cnpj : null, 
				nome : null, /* DADO FALTANDO */
				endereco : 'Rua Maciel Pinheiro 255, Centro',
				telefone : '34411312');
		assertFalse outroFornecedorInvalido.validate()
		outroFornecedorInvalido.save()
		assertNull Fornecedor.findByNome('OticaACT')
		assertEquals 0, Fornecedor.list().size()
		
		def maisOutroFornecedorInvalido = new Fornecedor(
				cnpj : null,
				nome : 'Ze', /* DADO INVALIDO */
				endereco : 'Rua Maciel Pinheiro 255, Centro',
				telefone : '34411312');
		assertFalse maisOutroFornecedorInvalido.validate()
		maisOutroFornecedorInvalido.save()
		assertNull Fornecedor.findByNome('Ze')
		assertEquals 0, Fornecedor.list().size()
		
		def maisUmOutroFornecedorInvalido = new Fornecedor(
				cnpj : null,
				nome : 'Otica Diniz', 
				endereco : 'Rua Maciel Pinheiro 255, Centro',
				telefone : '344113121289318931983');/* DADO INVALIDO */
		assertFalse maisUmOutroFornecedorInvalido.validate()
		maisUmOutroFornecedorInvalido.save()
		assertNull Fornecedor.findByNome('Otica Diniz')
		assertEquals 0, Fornecedor.list().size()
	}
	
	/**
	 * Teste de Aceitação 8.3: Retirar fornecedor existente da lista dos fornecedores (Operação Realizada com Sucesso).
	 */
	void test8_3() {
		assertEquals 0, Fornecedor.list().size()
		def fornecedorValido = new Fornecedor(
				cnpj : '1234567890',
				nome : 'OticaACT',
				endereco : 'Rua Maciel Pinheiro 255, Centro',
				telefone : '34411312');
		assertTrue fornecedorValido.validate()
		fornecedorValido.save()
		assertEquals 1, Fornecedor.list().size()
		assertNotNull Fornecedor.findByNome('OticaACT')
		fornecedorValido.delete()
		assertNull Fornecedor.findByNome('OticaACT')
		assertEquals 0, Fornecedor.list().size()
		
		def novoFornecedorValido = new Fornecedor(
				cnpj : '98765312',
				nome : 'Paraiso das lentes',
				endereco : 'Rua Miguel Couto, Catole',
				telefone : '0800072679');
		assertTrue novoFornecedorValido.validate()
		novoFornecedorValido.save()
		assertEquals 1, Fornecedor.list().size()
		assertNotNull Fornecedor.findByNome('Paraiso das lentes')
		novoFornecedorValido.delete()
		assertNull Fornecedor.findByNome('Paraiso das lentes')
		assertEquals 0, Fornecedor.list().size()
		
		def outroFornecedorValido = new Fornecedor(
				cnpj : null,
				nome : 'Otica diniz',
				endereco : 'Rua do pelourinho, Pelourinho',
				telefone : null);
		assertTrue outroFornecedorValido.validate()
		outroFornecedorValido.save()
		assertNotNull Fornecedor.findByNome('Otica diniz')
		outroFornecedorValido.delete()
		assertNull Fornecedor.findByNome('Otica diniz')
		assertEquals 0, Fornecedor.list().size()
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
		
		def novoFornecedorValido = new Fornecedor(
				cnpj : '98765312',
				nome : 'Paraiso das lentes',
				endereco : 'Rua Miguel Couto, Catole',
				telefone : '0800072679');
		assertTrue novoFornecedorValido.validate()
		novoFornecedorValido.save()
		assertNotNull Fornecedor.findByNome('Paraiso das lentes')
		assertEquals 'Paraiso das lentes', Fornecedor.findByNome('Paraiso das lentes').getNome()
		assertEquals 'Rua Miguel Couto, Catole', Fornecedor.findByNome('Paraiso das lentes').getEndereco()
		assertEquals '0800072679', Fornecedor.findByNome('Paraiso das lentes').getTelefone()
		assertEquals '98765312', Fornecedor.findByNome('Paraiso das lentes').getCnpj()
		
		def outroFornecedorValido = new Fornecedor(
				cnpj : null,
				nome : 'Otica diniz',
				endereco : 'Rua do pelourinho, Pelourinho',
				telefone : null);
		assertTrue outroFornecedorValido.validate()
		outroFornecedorValido.save()
		assertNotNull Fornecedor.findByNome('Otica diniz')
		assertEquals 'Otica diniz', Fornecedor.findByNome('Otica diniz').getNome()
		assertEquals 'Rua do pelourinho, Pelourinho', Fornecedor.findByNome('Otica diniz').getEndereco()
		assertNull Fornecedor.findByNome('Otica diniz').getTelefone()
		assertNull Fornecedor.findByNome('Otica diniz').getCnpj()
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
		
		def novoFornecedorValido = new Fornecedor(
				cnpj : '98765312',
				nome : 'Paraiso das lentes',
				endereco : 'Rua Miguel Couto, Catole',
				telefone : '0800072679');
		assertTrue novoFornecedorValido.validate()
		novoFornecedorValido.save()
		assertNotNull Fornecedor.findByNome('Paraiso das lentes')
		novoFornecedorValido.setCnpj '234567'
		novoFornecedorValido.setEndereco 'Rua das Flores, Natal RN'
		novoFornecedorValido.setTelefone '33371108'
		novoFornecedorValido.save()
		
		assertEquals '234567', Fornecedor.findByNome('Paraiso das lentes').getCnpj()
		assertEquals '33371108', Fornecedor.findByNome('Paraiso das lentes').getTelefone()
		assertEquals 'Rua das Flores, Natal RN', Fornecedor.findByNome('Paraiso das lentes').getEndereco()
		
		def outroFornecedorValido = new Fornecedor(
				cnpj : null,
				nome : 'Otica diniz',
				endereco : 'Rua do pelourinho, Pelourinho',
				telefone : null);
		assertTrue outroFornecedorValido.validate()
		outroFornecedorValido.save()
		assertNotNull Fornecedor.findByNome('Otica diniz')
		outroFornecedorValido.setCnpj '65498'
		novoFornecedorValido.setTelefone '33101343'
		novoFornecedorValido.save()
		
		assertEquals '65498', Fornecedor.findByNome('Otica diniz').getCnpj()
		assertEquals '33101343', Fornecedor.findByNome('Paraiso das lentes').getTelefone()
		
		def maisOutroFornecedorValido = new Fornecedor(
				cnpj : '19812112',
				nome : 'Otica da Budega',
				endereco : 'Rua do pelourinho, Pelourinho',
				telefone : '558333107865');
		assertTrue maisOutroFornecedorValido.validate()
		maisOutroFornecedorValido.save()
		assertNotNull Fornecedor.findByNome('Otica da Budega')
		maisOutroFornecedorValido.setNome 'Otica da Esquina'
		novoFornecedorValido.save()
		
		assertNull Fornecedor.findByNome('Otica da Budega')
		assertNotNull Fornecedor.findByNome('Otica da Esquina')
		
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
