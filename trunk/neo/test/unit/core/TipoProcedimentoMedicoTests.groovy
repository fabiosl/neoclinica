package core

import grails.test.GrailsUnitTestCase;

/**
 * Alguns tipos de testes, como valores base negativos nao sao testados nos testes de unidade porque
 * essas restricoes sao gravadas no banco de dados, entao nao tem como ser testadas aqui. Esse tipo de 
 * teste eh feito nos testes de integracao
 *
 */

class TipoProcedimentoMedicoTests extends GrailsUnitTestCase{

	def testTipoProcedimentoMedico(){
		
		def procedimentoUm = new TipoProcedimentoMedico(nome: 'Exame', valorBase: 10.0f)
		def procedimentoDois = new TipoProcedimentoMedico(nome: 'Retorno', valorBase: 0.0f)
		def procedimentoTres = new TipoProcedimentoMedico(nome: 'Retornos', valorBase: 1.0f)
		def procedimentoQuatro = new TipoProcedimentoMedico(nome: 'Exame', valorBase: 15.0f)
		
		assertEquals('Exame', procedimentoUm.toString())
		assertEquals('Retorno', procedimentoDois.toString())
		assertEquals('Retornos', procedimentoTres.toString())
		assertEquals('Exame', procedimentoQuatro.toString())
		assertEquals(-1, procedimentoUm.compareTo(procedimentoDois))
		assertEquals(-1, procedimentoDois.compareTo(procedimentoTres))
		assertEquals(0, procedimentoUm.compareTo(procedimentoQuatro))
		assertEquals(1, procedimentoDois.compareTo(procedimentoUm))
	}
}
