package core


import grails.test.GrailsUnitTestCase;

/**
 * Classe de teste da classe de dominio que modela os fornecimentos do sistema.
 */
class FornecimentoTests extends GrailsUnitTestCase {
	def testCreate(){
		def f1 = new Fornecimento(
			dataPedido : new Date(2),
			dataRecebimento: null,
			quantidade: 10,
			preco : 15
		);
	
		assertEquals new Date(2), f1.getDataPedido();
		assertEquals 10, f1.getQuantidade();
		assertEquals 15, f1.getPreco();
		assertEquals "Pendente", f1.statusDeEntrega()
		
		def data = new Date()
		def f2 = new Fornecimento(
			dataPedido : data,
			dataRecebimento: data,
			quantidade: 90,
			preco : 18
		);
	
		assertEquals data, f2.getDataPedido();
		assertEquals data, f2.getDataRecebimento();
		assertEquals 90, f2.getQuantidade();
		assertEquals 18, f2.getPreco();
		assertEquals "Entregue", f2.statusDeEntrega()
	}
}
