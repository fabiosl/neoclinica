package acesso;

import grails.test.GrailsUnitTestCase;

/**
 * Classe de teste da classe de dominio dos usuarios.
 */
class UsuarioTests extends GrailsUnitTestCase {
	void testCreate() {
		def u1 = new Usuario(
				username:'teste',
				userRealName :'Usuario de teste 1',
				enabled : true,
				email : 'teste@teste.com',
				passwd : 'senhasemcriptografia');
		def u2 = new Usuario(
				username:'teste2',
				userRealName :'Usuario de teste 2',
				enabled : false,
				email : 'teste2@teste.com',
				passwd : 'teste2');
		def u3 = new Usuario(
				username:'teste3',
				userRealName :'Usuario de teste 3',
				enabled : true,
				email : '',
				passwd : 'senhaaa');
		
		
		assertEquals u1.getUsername(), "teste"
		assertEquals u2.getUsername(), "teste2"
		assertEquals u3.getUsername(), "teste3"
		
		assertEquals u1.getUserRealName(), "Usuario de teste 1"
		assertEquals u2.getUserRealName(), "Usuario de teste 2"
		assertEquals u3.getUserRealName(), "Usuario de teste 3"
		
		assertEquals u1.getPasswd(), "senhasemcriptografia"
		assertEquals u2.getPasswd(), "teste2"
		assertEquals u3.getPasswd(), "senhaaa"
		
		assertTrue u1.isEnabled()
		assertFalse u2.isEnabled()
	}
}
