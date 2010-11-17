package core

import grails.test.GrailsUnitTestCase;

class CompraTests extends GrailsUnitTestCase {
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
		
		def c1 = new Compra(pagamento : null,
				paciente : p1, dataPedido : new Date(),
				dataRecebimento : new Date());
		
		assertNull(c1.getPagamento());
		assertEquals(c1.getPaciente().getNome(), "Renato");
		assertEquals(c1.getValor(), 0.0);
		
		def pag = new Pagamento(formaDePagamento: FormaDePagamento.DINHEIRO, cartao: null);
		
		def c2 = new Compra(pagamento: pag,
			paciente: p1, dataPedido: new Date(),
			dataRecebimento: new Date());
		
		assertNotNull(c2.getPagamento());
		assertEquals(pag, c2.getPagamento())
		assertEquals(c1.getPaciente().getNome(), "Renato");
		assertEquals(c1.getValor(), 0.0);
		
	}
	
	def testStatusEntrega() {
		def p1 = new Paciente(
				nome : "Renato",
				endereco : "Rua Teste, 250, Santa Rosa, Campina Grande, PB",
				telefone : "44442222",
				nascimento : new Date(90, 4, 25),
				sexo : Sexo.MASCULINO,
				profissao : "Estudante",
				rg : "44414141",
				idExterno : 0);
		
		def c1 = new Compra(pagamento : null,
				paciente : p1, dataPedido : new Date(),
				dataRecebimento : new Date());
		
		def c2 = new Compra(pagamento : null,
				paciente : p1, dataPedido : new Date(),
				dataRecebimento : null);
		
		assertEquals(c1.getPaciente(), c2.getPaciente());
		assertEquals(c1.statusDeEntrega(), "Entregue");
		assertEquals(c2.statusDeEntrega(), "Pendente");
	}
}
