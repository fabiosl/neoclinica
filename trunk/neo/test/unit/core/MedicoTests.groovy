package core

import grails.test.GrailsUnitTestCase;

/**
 * Classe de teste da classe de dominio que modela os pacientes do sistema.
 */
class MedicoTests extends GrailsUnitTestCase {
	
	def testCreate() {
		def m1 = new Medico(
				crm : "1234",
				especialidade : "Oftalmologia",
				username : "harrison",
				userRealName : "Harrison Sarmento",
				passwd : "123456",
				enabled :true,
				email:"harrison73oft@gmail.com",
				emailShow : true,
				description : ''
				);
		assertEquals "harrison", m1.getUsername()
		assertEquals "1234", m1.getCrm()
		assertEquals "harrison73oft@gmail.com", m1.getEmail();
		assertEquals "Oftalmologia", m1.getEspecialidade();
		
		
		
	}
}