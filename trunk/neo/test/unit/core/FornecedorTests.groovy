package core


import grails.test.GrailsUnitTestCase;

/**
 * Classe de teste da classe de dominio que modela os fornecedores do sistema.
 */
class FornecedorTests extends GrailsUnitTestCase {
	
	def testCreate(){
		def f1 = new Fornecedor(
				cnpj : "0000000",
				nome : "Fornecedor",
				endereco : "Rua rodrigues alves ",
				telefone : "32244444");
		
		assertEquals "0000000", f1.getCnpj();
		assertEquals "Fornecedor", f1.getNome();
		assertEquals "Rua rodrigues alves ", f1.getEndereco();
		assertEquals "32244444", f1.getTelefone();
		assertEquals "Fornecedor", f1.toString();
		
		def f2 = new Fornecedor(
			cnpj : "123456",
			nome : "Rio do Peixe",
			endereco : "Shopping",
			telefone : "999999999");
		assertEquals "Rio do Peixe", f2.toString();
	}
}
