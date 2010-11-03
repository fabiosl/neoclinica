package core

import grails.test.GrailsUnitTestCase;

/**
 * Classe de teste da classe de dominio que modela os pacientes do sistema.
 */
class PacienteTests extends GrailsUnitTestCase {
	/*
	 * Obs.: Os testes serao evoluidos conforme o modelo evoluir (acrescentar procedimentos, etc.)
	 */
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
}
