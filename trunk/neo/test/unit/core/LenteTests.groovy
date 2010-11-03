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
		assertEquals 10, l1.getQuantidade();
		float f = 10.2
		assertEquals f, l1.getValor();
	}
}

