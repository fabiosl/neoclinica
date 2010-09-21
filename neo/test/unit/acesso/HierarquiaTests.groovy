package acesso

import grails.test.GrailsUnitTestCase;

/**
 * Classe de teste da classe de dominio dos papeis do sistema.
 */
class HierarquiaTests extends GrailsUnitTestCase {
	void testCreate() {
		def h1 = new Hierarquia(description:"Escravo", authority:"ROLE_ESCRAVO")
		def h2 = new Hierarquia(description:"Rei", authority:"ROLE_REI")
		def h3 = new Hierarquia(description:"Outro", authority:"ROLE_OUTRO")
		
		assertEquals h1.getDescription(), "Escravo"
		assertEquals h2.getDescription(), "Rei"
		assertEquals h3.getDescription(), "Outro"
		
		assertEquals h1.getAuthority(), "ROLE_ESCRAVO"
		assertEquals h2.getAuthority(), "ROLE_REI"
		assertEquals h3.getAuthority(), "ROLE_OUTRO"
		
		assertEquals h1.getPeople().size(), 0
		assertEquals h2.getPeople().size(), 0
		assertEquals h3.getPeople().size(), 0
	}
}
