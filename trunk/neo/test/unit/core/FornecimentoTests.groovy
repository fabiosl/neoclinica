package core


import grails.test.GrailsUnitTestCase;

/**
 * Classe de teste da classe de dominio que modela os fornecimentos do sistema.
 */
class FornecimentoTests extends GrailsUnitTestCase {
	def testCreate(){
		def f1 = new Fornecimento(
			dataPedido : new Date(2),
			quantidade: 10,
			preco : 15
		);
	
		assertEquals new Date(2), f1.getDataPedido();
		assertEquals 10, f1.getQuantidade();
		assertEquals 15, f1.getPreco();
	}
}
