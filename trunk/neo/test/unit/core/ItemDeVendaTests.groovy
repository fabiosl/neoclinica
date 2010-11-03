package core

import grails.test.GrailsUnitTestCase;

class ItemDeVendaTests extends GrailsUnitTestCase {
	def testCreate() {		
		def l1 = new Lente(tipo : "ZYX",
				quantidade : 10,
				valor : 10.2);
		def i1 = new ItemDeVenda(lente : l1, quantidadeComprada : 10);
		
		assertEquals(i1.getQuantidadeComprada(), 10);
		assertEquals(i1.getLente().getTipo(), "ZYX");
	}
	
	def testValorTotal() {
		def l1 = new Lente(tipo : "ZYX",
				quantidade : 10,
				valor : 10.2);
		
		def i1 = new ItemDeVenda(lente : l1, quantidadeComprada : 10);
		def i2 = new ItemDeVenda(lente : l1, quantidadeComprada : 20);
		def i3 = new ItemDeVenda(lente : l1, quantidadeComprada : 1);
		
		assertEquals(i1.valorTotal(), 102.0);
		assertEquals(i2.valorTotal(), 204.0);
		assertEquals(i3.valorTotal(), 10.2f);
	}
}
