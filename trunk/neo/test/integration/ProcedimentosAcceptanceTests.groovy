
import acesso.Hierarquia;
import core.FormaDePagamento 
import core.Medico 
import core.Paciente 
import core.Pagamento 
import core.ProcedimentoMedico 
import core.Sexo;
import core.TipoProcedimentoMedico 
import groovy.util.GroovyTestCase;

/**
 * Testes de aceitacao da user story 9 (Controle de Procedimentos)
 */
class ProcedimentosAcceptanceTests extends GroovyTestCase {
	void tearDown() {
		ProcedimentoMedico.list()*.delete();
		TipoProcedimentoMedico.list()*.delete();
		Pagamento.list()*.delete();
		Paciente.list()*.delete();
		Medico.list()*.delete();
		Hierarquia.list()*.delete();
	}
	
	/**
	 * Teste de Aceitação 9.1: Cadastrar procedimento no sistema com todos os dados corretos (Operação Realizada com Sucesso).
	 */
	void test9_1() {
		def data = new Date();
		def p = new Paciente(nome: 'Jose', sexo: Sexo.MASCULINO)
		p.save()
		def hierar = new Hierarquia(authority: 'Super Usuario')
		hierar.save()
		def med = new Medico(username: 'u',userRealName: 'Jose', passwd: '123', authorities: hierar)
		med.save()
		def procedimento = new ProcedimentoMedico(
				tipo : new TipoProcedimentoMedico(nome: 'Exame', valorBase: 10.0f),
				data : new Date(),
				informacoes : 'Exames realizados na clinica',
				valor: 10.0f,
				pagamento: new Pagamento(formaDePagamento: FormaDePagamento.DINHEIRO),
				medico: med,
				paciente: p);
		assertTrue procedimento.validate()
		procedimento.save()
		assertNotNull ProcedimentoMedico.findByInformacoes('Exames realizados na clinica')
	}
	
	/**
	 * Cadastrar procedimento no sistema com dados faltando (Operação Realizada sem Sucesso).
	 */
	void test9_2() {
		def tipoProc = new TipoProcedimentoMedico(nome: 'Exame', valorBase: 10.0f)
		tipoProc.save()
		def procedimento = new ProcedimentoMedico(
				tipo : tipoProc,
				data : new Date(),
				informacoes : 'Exames realizados na clinica',
				valor: 10.0f,
				pagamento: new Pagamento(formaDePagamento: FormaDePagamento.DINHEIRO));
		assertFalse procedimento.validate()
		procedimento.save()
		assertNull ProcedimentoMedico.findByTipo(tipoProc)
		assertNull ProcedimentoMedico.findByValor(10.0f)
		
		def procedimento2 = new ProcedimentoMedico(
			tipo : tipoProc,
			informacoes : 'Exames realizados',
			valor: 14.0f,
			pagamento: new Pagamento(formaDePagamento: FormaDePagamento.DINHEIRO));
		assertFalse procedimento2.validate()
		procedimento2.save()
		assertNull ProcedimentoMedico.findByTipo(tipoProc)
		assertNull ProcedimentoMedico.findByValor(10.0f)
		assertNull ProcedimentoMedico.findByData(new Date())
		
		def procedimento3 = new ProcedimentoMedico(
			tipo : tipoProc,
			data : new Date(),
			informacoes : 'Exames realizados',
			pagamento: new Pagamento(formaDePagamento: FormaDePagamento.DINHEIRO));
		assertFalse procedimento3.validate()
		procedimento3.save()
		assertNull ProcedimentoMedico.findByTipo(tipoProc)
		assertNull ProcedimentoMedico.findByValor(10.0f)
		assertNull ProcedimentoMedico.findByData(new Date())
	}
	
	/**
	 * Teste de Aceitação 9.3: Retirar procedimento existente da lista de procedimentos (Operação Realizada com Sucesso).
	 */
	void test9_3() {
		def tipoProc = new TipoProcedimentoMedico(nome: 'Exame', valorBase: 10.0f)
		tipoProc.save()
		def dataAgora = new Date()
		def pagamentoCartao = new Pagamento(formaDePagamento: FormaDePagamento.DINHEIRO)
		pagamentoCartao.save()
		def procedimento = new ProcedimentoMedico(
			tipo : tipoProc,
			data : dataAgora,
			informacoes : 'Exames realizados na clinica',
			valor: 10.0f,
			pagamento: pagamentoCartao);
		assertTrue procedimento.validate()
		procedimento.save()
		assertNotNull ProcedimentoMedico.findByInformacoes('Exames realizados na clinica')
		procedimento.delete()
		assertNull ProcedimentoMedico.findByInformacoes('Exames realizados na clinica')
		assertNull ProcedimentoMedico.findByValor(10.0f)
		
		def procedimento2 = new ProcedimentoMedico(
			tipo : tipoProc,
			data : dataAgora,
			informacoes : 'Exames realizados na clinica',
			valor: 10.0f,
			pagamento: pagamentoCartao);
		def procedimento3 =  new ProcedimentoMedico(
			tipo : tipoProc,
			data : dataAgora,
			informacoes : 'Exames realizados no hospital',
			valor: 100.0f,
			pagamento: pagamentoCartao);
		assertTrue procedimento2.validate()
		assertTrue procedimento3.validate()
		procedimento2.save()
		procedimento3.save()
		assertNotNull ProcedimentoMedico.findByInformacoes('Exames realizados na clinica')
		assertNotNull ProcedimentoMedico.findByInformacoes('Exames realizados no hospital')
		procedimento2.delete()
		assertNull ProcedimentoMedico.findByInformacoes('Exames realizados na clinica')
		assertNotNull ProcedimentoMedico.findByInformacoes('Exames realizados no hospital')
		
	}
	
	
	
	/**
	 * Teste de Aceitação 9.4: Retirar procedimento inexistente da lista de procedimentos (Operação Realizada sem Sucesso).
	 */
	void test9_4() {
		def tipoProc = new TipoProcedimentoMedico(nome: 'Exame', valorBase: 10.0f)
		def dataAgora = new Date()
		def pagamentoCartao = new Pagamento(cartao: '')
		tipoProc.save()
		pagamentoCartao.save()
		def procedimento = new ProcedimentoMedico(
			tipo : tipoProc,
			data : dataAgora,
			informacoes : 'Exames realizados na clinica',
			valor: 10.0f,
			pagamento: pagamentoCartao);
		def procedimento2 = new ProcedimentoMedico(
			tipo : tipoProc,
			data : dataAgora,
			informacoes : 'Exames realizados no hospital',
			valor: 10.0f,
			pagamento: pagamentoCartao);
		def procedimento3 =  new ProcedimentoMedico(
			tipo : tipoProc,
			data : dataAgora,
			informacoes : 'Exames realizados no hospital',
			valor: 100.0f,
			pagamento: pagamentoCartao);
		assertNull ProcedimentoMedico.findByInformacoes('Exames realizados no hospital')
		assertNull ProcedimentoMedico.findByInformacoes('Exames realizados na clinica')
		assertNull ProcedimentoMedico.findByValor(10.0f)
		assertNull ProcedimentoMedico.findByValor(100.0f)
		assertNull ProcedimentoMedico.findByData(dataAgora)
	}
	
	/**
	 * Teste de Aceitação 9.5: Consultar dados de procedimento existente no sistema (Operação Realizada com Sucesso).
	 */
	void test9_5() {
		def tipoProc = new TipoProcedimentoMedico(nome: 'Exame', valorBase: 10.0f)
		def dataAgora = new Date()
		def pagamentoCartao = new Pagamento(cartao: '')
		tipoProc.save()
		pagamentoCartao.save()
		def procedimento = new ProcedimentoMedico(
			tipo : tipoProc,
			data : dataAgora,
			informacoes : 'Exames realizados na clinica',
			valor: 10.0f,
			pagamento: pagamentoCartao);
		procedimento.save()
//		assertNotNull ProcedimentoMedico.findByInformacoes('Exames realizados na clinica')
		assertNull ProcedimentoMedico.findByInformacoes('Exames realizados no hospital')
		assertNotNull ProcedimentoMedico.findByValor(10.0)
		assertNotNull ProcedimentoMedico.findByData(dataAgora)
		assertEquals 'Exame', ProcedimentoMedico.findByTipo(tipoProc).getTipo().toString()
		assertEquals 0f, ProcedimentoMedico.findByInfor(tipoProc).getValor()
		assertEquals 'Exames realizados na clinica', ProcedimentoMedico.findByValor(10.0f).getInformacoes()
	}
	
	/**
	 * Teste de Aceitação 9.6: Consultar dados de procedimento inexistente no sistema (Operação Realizada sem Sucesso).
	 */
	void test9_6() {
		def tipoProc = new TipoProcedimentoMedico(nome: 'Exame', valorBase: 10.0f)
		def dataAgora = new Date()
		def pagamentoCartao = new Pagamento(cartao: '')
		tipoProc.save()
		pagamentoCartao.save()
		def procedimento = new ProcedimentoMedico(
			tipo : tipoProc,
			data : dataAgora,
			informacoes : 'Exames realizados na clinica',
			valor: 10.0f,
			pagamento: pagamentoCartao);
		assertNull ProcedimentoMedico.findByValor(100.0f)
		try {
			assertEquals 'ProcedimentoNaoCadastrado', ProcedimentoMedico.findByTipo(tipoProc).getTipo()
			assertEquals 2f, ProcedimentoMedico.findByValor(100.0f).getValor()
			fail()
		} catch (Exception e) {
		}
	}
	
	/**
	 * Teste de Aceitação 9.7: Atualizar dados de procedimento existente no sistema (Operação Realizada com Sucesso).
	 */
	void test9_7() {
		def tipoProc = new TipoProcedimentoMedico(nome: 'Exame', valorBase: 10.0f)
		def dataAgora = new Date()
		def pagamentoCartao = new Pagamento(cartao: '')
		tipoProc.save()
		pagamentoCartao.save()
		def procedimento = new ProcedimentoMedico(
			tipo : tipoProc,
			data : dataAgora,
			informacoes : 'Exames realizados na clinica',
			valor: 10.0f,
			pagamento: pagamentoCartao);
		procedimento.save()
		
		assertNotNull ProcedimentoMedico.findByValor(10.0f)
		procedimento.setValor 18.89f
		procedimento.save()
		
		assertEquals 18.89f, ProcedimentoMedico.findByInformacoes('Exames realizados na clinica').getValor()
		assertEquals 18.89f, ProcedimentoMedico.findByValor(18.89f).getValor()
	}
	
	/**
	 * Teste de Aceitação 9.8: Atualizar dados de procedimento inexistente no sistema (Operação Realizada sem Sucesso). 
	 */
	void test9_8() {
		assertNull ProcedimentoMedico.findByValor(100.0f)
		def instanciaNaoExistente = ProcedimentoMedico.findByValor(100.0f)
		try {
			instanciaNaoExistente.setValor 39.25
			fail()
		} catch (Exception e) {
		}
	}
}
