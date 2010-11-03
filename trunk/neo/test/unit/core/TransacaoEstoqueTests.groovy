package core

import grails.test.GrailsUnitTestCase;
import java.text.DateFormat 

class TransacaoEstoqueTests extends GrailsUnitTestCase{
	
	def testTransacaoEstoque(){
		
		def lenteVendida = new Lente(
				tipo : "ZYX",
				quantidade : 10,
				valor : 10.2
				);
		def lenteRecebida = new Lente(
				tipo : "ABC",
				quantidade : 87,
				valor : 15.45
				);
		def lenteNova = new Lente(
				tipo : "JKL",
				quantidade : 0,
				valor : 0
				);
		def data = new Date()
		def fornecedor = new Fornecedor(
				cnpj : "0000000",
				nome : "Fornecedor",
				endereco : "Rua rodrigues alves ",
				telefone : "32244444");
		
		def transacaoUm = new TransacaoEstoque(lenteVendida, data, TransacaoKind.VENDA, 'Camila', 10, fornecedor)
		def transacaoDois = new TransacaoEstoque(lenteRecebida, data, TransacaoKind.CHEGADA, 'Camila', 56, fornecedor)
		def transacaoTres = new TransacaoEstoque(lenteNova, data, TransacaoKind.CADASTRO, 'Camila', 0, fornecedor)
		
		assertEquals("Transação do tipo VENDA. Data Realizacao " + data.toString() + ". Operador: Camila. Quantidade de itens mexidos: 10", transacaoUm.toString())
		assertEquals("Transação do tipo CHEGADA. Data Realizacao " + data.toString() + ". Operador: Camila. Quantidade de itens mexidos: 56", transacaoDois.toString())
		assertEquals("Transação do tipo CADASTRO. Data Realizacao " + data.toString() + ". Operador: Camila. Quantidade de itens mexidos: 0", transacaoTres.toString())
	}

}
