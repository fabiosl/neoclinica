package core

import grails.test.GrailsUnitTestCase;

/**
 * Classe de teste da classe de dominio que modela os convenios aceitos no sistema.
 */
class ConvenioTests extends GrailsUnitTestCase {
	def testCreate() {
		def c1 = new Convenio(
				nome : "Unimed");		
		def c2 = new Convenio(
				nome : "ConvenioTest");
		
		assertEquals c1.getNome(), "Unimed";
		assertEquals c2.getNome(), "ConvenioTest";
	}
}
