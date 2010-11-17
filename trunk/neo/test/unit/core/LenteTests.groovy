package core

import grails.test.GrailsUnitTestCase;

/**
 * Classe de teste da classe de dominio que modela as lentes do sistema.
 */


class LenteTests extends GrailsUnitTestCase {
	def testCreate() {
		def l1 = new Lente(
				tipo : "ZYX",
				quantidade : 10,
				valor : 10.2
				);
		
		assertEquals "ZYX", l1.getTipo();
		assertEquals l1.descricao(), "ZYX / Quantidade em estoque: (10)";
		assertEquals 10, l1.getQuantidade();
		float f = 10.2
		assertEquals f, l1.getValor();
		
		def l2 = new Lente(tipo : "Lente de Cego",
			quantidade : 1000,
			valor : 13.89);
		
		assertEquals "Lente de Cego", l2.getTipo();
		assertEquals l2.descricao(), "Lente de Cego / Quantidade em estoque: (1000)";
		assertEquals 1000, l2.getQuantidade();
		assertEquals 13.89f, l2.getValor();
	}
}

