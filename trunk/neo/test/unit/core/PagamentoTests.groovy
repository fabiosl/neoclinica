package core

import grails.test.GrailsUnitTestCase;

class PagamentoTests extends GrailsUnitTestCase{

	def testAVista(){
		def pagamentoUm = new Pagamento(1, FormaDePagamento.DINHEIRO, null)
		assertNull pagamentoUm.getCartao()
		assertTrue pagamentoUm.pagoAVista()
		assertEquals('Dinheiro', pagamentoUm.formaDePagamento.getDescricao())
		assertEquals("À vista / Dinheiro", pagamentoUm.formaDePagamento())
		assertEquals("À vista / Dinheiro", pagamentoUm.toString())
		pagamentoUm.jaFinalizado()
		
		def pagamentoDois = new Pagamento(0, FormaDePagamento.DINHEIRO, null)
		assertNull pagamentoDois.getCartao()
		assertTrue pagamentoDois.pagoAVista()
		assertEquals('Dinheiro', pagamentoDois.formaDePagamento.getDescricao())
		assertEquals("À vista / Dinheiro", pagamentoDois.formaDePagamento())
		assertEquals("À vista / Dinheiro", pagamentoDois.toString())
		pagamentoDois.jaFinalizado()
	}
	
	def testCartao(){
		def pagamentoUm = new Pagamento(3, FormaDePagamento.CARTAO, '12345')
		assertFalse pagamentoUm.pagoAVista()
		assertNotNull pagamentoUm.getCartao()
		assertEquals('12345', pagamentoUm.getCartao())
		assertEquals('Cartao', pagamentoUm.formaDePagamento.getDescricao())
		assertEquals("À prazo (3x) / Cartao (12345)", pagamentoUm.formaDePagamento())
		assertEquals("À prazo (3x) / Cartao (12345)", pagamentoUm.toString())
		pagamentoUm.jaFinalizado()
		
		def pagamentoDois = new Pagamento(1, FormaDePagamento.CARTAO, '98765')
		assertTrue pagamentoDois.pagoAVista()
		assertNotNull pagamentoDois.getCartao()
		assertEquals('98765', pagamentoDois.getCartao())
		assertEquals('Cartao', pagamentoDois.formaDePagamento.getDescricao())
		assertEquals("À vista / Cartao (98765)", pagamentoDois.formaDePagamento())
		assertEquals("À vista / Cartao (98765)", pagamentoDois.toString())
		pagamentoDois.jaFinalizado()
	}
	
	def testCheque(){
		def pagamentoUm = new Pagamento(3, FormaDePagamento.CHEQUE, null)
		assertFalse pagamentoUm.pagoAVista()
		assertNull pagamentoUm.getCartao()
		assertEquals("À prazo (3x) / Cheque", pagamentoUm.formaDePagamento())
		assertEquals("À prazo (3x) / Cheque", pagamentoUm.toString())
		pagamentoUm.jaFinalizado()
		
		def pagamentoDois = new Pagamento(1, FormaDePagamento.CHEQUE, null)
		assertTrue pagamentoDois.pagoAVista()
		assertNull pagamentoDois.getCartao()
		assertEquals("À vista / Cheque", pagamentoDois.formaDePagamento())
		assertEquals("À vista / Cheque", pagamentoDois.toString())
		assertFalse pagamentoDois.jaFinalizado()
	}
}
