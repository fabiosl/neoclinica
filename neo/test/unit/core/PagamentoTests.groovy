package core

import grails.test.GrailsUnitTestCase;

class PagamentoTests extends GrailsUnitTestCase{
	
	def testAVista(){
		def pagamentoUm = new Pagamento()
		configuraPrestacoes(pagamentoUm, 1)
		pagamentoUm.setFormaDePagamento(FormaDePagamento.DINHEIRO)
		assertNull pagamentoUm.getCartao()
		assertTrue pagamentoUm.pagoAVista()
		assertEquals('Dinheiro', pagamentoUm.formaDePagamento.getDescricao())
		assertEquals("À vista / Dinheiro", pagamentoUm.formaDePagamento())
		assertEquals("À vista / Dinheiro", pagamentoUm.toString())
		pagamentoUm.jaFinalizado()
		
		def pagamentoDois = new Pagamento()
		configuraPrestacoes(pagamentoDois, 1)
		pagamentoDois.setFormaDePagamento(FormaDePagamento.DINHEIRO)
		assertNull pagamentoDois.getCartao()
		assertTrue pagamentoDois.pagoAVista()
		assertEquals('Dinheiro', pagamentoDois.formaDePagamento.getDescricao())
		assertEquals("À vista / Dinheiro", pagamentoDois.formaDePagamento())
		assertEquals("À vista / Dinheiro", pagamentoDois.toString())
		pagamentoDois.jaFinalizado()
	}
	
	def testCartao(){
		def pagamentoUm = new Pagamento()
		configuraPrestacoes(pagamentoUm, 3)
		pagamentoUm.setCartao('12345')
		pagamentoUm.setFormaDePagamento(FormaDePagamento.CARTAO)
		assertFalse pagamentoUm.pagoAVista()
		assertNotNull pagamentoUm.getCartao()
		assertEquals('12345', pagamentoUm.getCartao())
		assertEquals('Cartao', pagamentoUm.formaDePagamento.getDescricao())
		assertEquals("À prazo (3x) / Cartao (12345)", pagamentoUm.formaDePagamento())
		assertEquals("À prazo (3x) / Cartao (12345)", pagamentoUm.toString())
		pagamentoUm.jaFinalizado()
		
		def pagamentoDois = new Pagamento()
		configuraPrestacoes(pagamentoDois, 1)
		pagamentoDois.setCartao('98765')
		pagamentoDois.setFormaDePagamento(FormaDePagamento.CARTAO)
		assertTrue pagamentoDois.pagoAVista()
		assertNotNull pagamentoDois.getCartao()
		assertEquals('98765', pagamentoDois.getCartao())
		assertEquals('Cartao', pagamentoDois.formaDePagamento.getDescricao())
		assertEquals("À vista / Cartao (98765)", pagamentoDois.formaDePagamento())
		assertEquals("À vista / Cartao (98765)", pagamentoDois.toString())
		pagamentoDois.jaFinalizado()
	}
	
	def testCheque(){
		def pagamentoUm = new Pagamento()
		configuraPrestacoes(pagamentoUm, 3)
		pagamentoUm.setFormaDePagamento(FormaDePagamento.CHEQUE)
		assertFalse pagamentoUm.pagoAVista()
		assertNull pagamentoUm.getCartao()
		assertEquals("À prazo (3x) / Cheque", pagamentoUm.formaDePagamento())
		assertEquals("À prazo (3x) / Cheque", pagamentoUm.toString())
		pagamentoUm.jaFinalizado()
		
		def pagamentoDois = new Pagamento()
		configuraPrestacoes(pagamentoDois, 1)
		pagamentoDois.setFormaDePagamento(FormaDePagamento.CHEQUE)
		assertTrue pagamentoDois.pagoAVista()
		assertNull pagamentoDois.getCartao()
		assertEquals("À vista / Cheque", pagamentoDois.formaDePagamento())
		assertEquals("À vista / Cheque", pagamentoDois.toString())
		assertFalse pagamentoDois.jaFinalizado()
	}
	
	def configuraPrestacoes(Pagamento p, int quantidade) {
		p.setPrestacoes(new HashSet())
		for (int i = 1; i <= quantidade; i++) {
			p.getPrestacoes().add(new Parcela(i))
		}
	}
}
