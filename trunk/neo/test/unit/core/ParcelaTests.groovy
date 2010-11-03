package core

import grails.test.GrailsUnitTestCase;

class ParcelaTests extends GrailsUnitTestCase{

	def testParcela(){
		def parcelaUm = new Parcela(1);
		def parcelaDois = new Parcela(-11);
		def parcelaTres = new Parcela(3);
		def parcelaQuatro = new Parcela(2);
		
		assertFalse parcelaUm.isPaga()
		assertFalse parcelaDois.isPaga()
		assertFalse parcelaTres.isPaga()
		assertFalse parcelaQuatro.isPaga()
		
		assertNull parcelaUm.getDataDePagamento()
		assertNull parcelaDois.getDataDePagamento()
		assertNull parcelaTres.getDataDePagamento()
		assertNull parcelaQuatro.getDataDePagamento()
	}
	
	def testPaga(){
		def parcelaUm = new Parcela(1);
		def parcelaDois = new Parcela(2);
		
		assertFalse parcelaUm.isPaga()
		assertNull parcelaUm.getDataDePagamento()
		assertFalse parcelaDois.isPaga()
		assertNull parcelaDois.getDataDePagamento()
		
		def dataPagamento = new Date()
		parcelaUm.paga = true;
		parcelaUm.dataDePagamento = dataPagamento
		parcelaUm.valor = 10.0f
		
		assertTrue parcelaUm.isPaga()
		assertNotNull parcelaUm.getDataDePagamento()
		assertEquals(parcelaUm.getDataDePagamento(), dataPagamento)
		
		def dataDois = new Date()
		parcelaDois.paga = true;
		parcelaDois.dataDePagamento = dataDois
		parcelaDois.valor = 15.0f
		
		assertTrue parcelaDois.isPaga()
		assertNotNull parcelaDois.getDataDePagamento()
		assertEquals(parcelaDois.getDataDePagamento(), dataDois)
	}
}
