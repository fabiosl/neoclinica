package core

import grails.test.GrailsUnitTestCase;

/**
 * Classe de teste da classe de dominio que modela os pacientes do sistema.
 */
class PacienteTests extends GrailsUnitTestCase {
	def testCreate() {
		def p1 = new Paciente(
				nome : "Renato",
				endereco : "Rua Teste, 250, Santa Rosa, Campina Grande, PB",
				telefone : "44442222",
				nascimento : new Date(90, 4, 25),
				sexo : Sexo.MASCULINO,
				profissao : "Estudante",
				rg : "44414141",
				idExterno : 0);
		
		def p2 = new Paciente(
				nome : "Fabio Leal",
				endereco : "Faixa de Gaza, 25, Bodocongo, Campina Grande, PB",
				telefone : "2223222",
				nascimento : new Date(90, 11, 30),
				sexo : Sexo.MASCULINO,
				profissao : "No-Life",
				rg : "44414242",
				idExterno : 1);
		
		assertEquals p1.getNome(), "Renato";
		assertEquals p1.getEndereco(), "Rua Teste, 250, Santa Rosa, Campina Grande, PB";
		assertEquals p1.calculaIdade(), 20;
		assertEquals p1.getIdExterno(), 0;
		
		assertEquals p2.getNome(), "Fabio Leal";
		assertEquals p2.calculaIdade(), 19;
		assertEquals p2.getIdExterno(), 1;
	}
	
	def testToString(){
		def p1 = new Paciente(
				nome : "Renato",
				endereco : "Rua Teste, 250, Santa Rosa, Campina Grande, PB",
				telefone : "44442222",
				nascimento : new Date(90, 4, 25),
				sexo : Sexo.MASCULINO,
				profissao : "Estudante",
				rg : "44414141",
				idExterno : 0);
		
		def p2 = new Paciente(
				nome : "Fabio Leal",
				endereco : "Faixa de Gaza, 25, Bodocongo, Campina Grande, PB",
				telefone : "2223222",
				nascimento : new Date(90, 11, 30),
				sexo : Sexo.MASCULINO,
				profissao : "No-Life",
				rg : "44414242",
				idExterno : 1);
			
			assertEquals "Renato", p1.toString()
			assertEquals "Fabio Leal", p2.toString()
	}
	
	def testDataNascimentoDDMMYY(){
		def p1 = new Paciente(
			nome : "Renato",
			endereco : "Rua Teste, 250, Santa Rosa, Campina Grande, PB",
			telefone : "44442222",
			nascimento : new Date(90, 4, 25),
			sexo : Sexo.MASCULINO,
			profissao : "Estudante",
			rg : "44414141",
			idExterno : 0);
	
	def p2 = new Paciente(
			nome : "Fabio Leal",
			endereco : "Faixa de Gaza, 25, Bodocongo, Campina Grande, PB",
			telefone : "2223222",
			nascimento : new Date(90, 11, 30),
			sexo : Sexo.MASCULINO,
			profissao : "No-Life",
			rg : "44414242",
			idExterno : 1);
		
		assertEquals "25/04/1990", p1.dataNascimentoDDMMYY()
		assertEquals "30/11/1990", p2.dataNascimentoDDMMYY()
	}
}
