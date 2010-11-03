package core

import grails.test.GrailsUnitTestCase;

class ProcedimentoMedicoTests extends GrailsUnitTestCase{
	
	def testProcedimentoMedico(){
		
		def tipoProcedimentoUm = new TipoProcedimentoMedico(nome: 'Exame', valorBase: 10.0f)
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
		def dataHoje = new Date()
		def procedimentoUm = new ProcedimentoMedico(tipo: tipoProcedimentoUm, data:dataHoje, informacoes: 'Exame da senhora cega', medico:m1)
		
		assertEquals(procedimentoUm.getInformacoes(), 'Exame da senhora cega')
		assertNotNull procedimentoUm.medico
		assertEquals(procedimentoUm.medico, m1)
		assertEquals(procedimentoUm.medico.userRealName, 'Harrison Sarmento')
		assertEquals(procedimentoUm.data, dataHoje)
		assertEquals(procedimentoUm.tipo.nome, 'Exame')
	}
}

