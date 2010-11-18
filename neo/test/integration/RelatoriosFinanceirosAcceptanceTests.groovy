import acesso.Hierarquia 
import core.Compra 
import core.FormaDePagamento 
import core.ItemDeVenda;
import core.Lente 
import core.Medico 
import core.Paciente 
import core.Pagamento 
import core.ProcedimentoMedico 
import core.Sexo 
import core.TipoProcedimentoMedico 
import groovy.util.GroovyTestCase;

/**
 * Testes de aceitacao da user story 10 (Geracao de Relatorios Financeiros)
 */
class RelatoriosFinanceirosAcceptanceTests extends GroovyTestCase {
	void tearDown() {
		ProcedimentoMedico.list()*.delete();
		Compra.list()*.delete();
		TipoProcedimentoMedico.list()*.delete();
		Lente.list()*.delete();
		Pagamento.list()*.delete();
		Paciente.list()*.delete();
		Medico.list()*.delete();
		Hierarquia.list()*.delete();
	}
	
	/**
	 * Teste de Aceitação 10.1: Emitir relatório por data dos procedimentos médicos realizadas (Operação Realizada com Sucesso se logado como Administrador ou Funcionário). 
	 */
	void test10_1(){
		def p = new Paciente(nome: 'teste', sexo: Sexo.MASCULINO, nascimento: new Date())
		p.save()
		def medicoValido = new Medico(
				username : 'renato',
				userRealName : 'renato',
				enabled : true,
				email : 'drrenato@gmail.com',
				passwd : 'drrenato',
				crm: '12441214',
				especialidade : 'Oftalmologista');
		medicoValido.save()
		def tipoProc = new TipoProcedimentoMedico(nome: 'Exame', valorBase: 10.0f)
		tipoProc.save()
		def tipoPag = new Pagamento(formaDePagamento: FormaDePagamento.DINHEIRO)
		tipoPag.save()
		
		Date data = new Date();
		
		def procedimento = new ProcedimentoMedico(
				tipo : tipoProc,
				data : data,
				informacoes : '',
				valor: 10.0f,
				pagamento: tipoPag,
				medico: medicoValido,
				paciente: p);
		assertTrue procedimento.validate()
		procedimento.save()
		
		assertEquals data, ProcedimentoMedico.findByData(data).list().iterator().next().getData();
		assertEquals 'renato', ProcedimentoMedico.findByData(data).list().iterator().next().getMedico().getUserRealName();
		assertEquals 'teste', ProcedimentoMedico.findByData(data).list().iterator().next().getPaciente().getNome();
		assertEquals 10.0f, ProcedimentoMedico.findByData(data).list().iterator().next().getValor();
		assertEquals 'Exame', ProcedimentoMedico.findByData(data).list().iterator().next().getTipo().getNome();
	}
	
	/**
	 * Teste de Aceitação 10.2: Emitir relatório por data das vendas de lentes realizadas (Operação Realizada com Sucesso se logado como Administrador ou Funcionário). 
	 */
	void test10_2(){
		def lenteValida = new Lente(
				tipo : 'Look',
				quantidade : 15,
				valor : 1f);
		lenteValida.save()
		
		def lenteValida2 = new Lente(
				tipo : 'RayBan',
				quantidade : 389,
				valor : 89f);
		lenteValida2.save()
		
		def p = new Paciente(nome: 'teste', sexo: Sexo.MASCULINO, nascimento: new Date())
		p.save()
		def pagamento = new Pagamento(formaDePagamento: FormaDePagamento.DINHEIRO)
		pagamento.save()
		
		Date data = new Date();
		
		def compra = new Compra(pagamento: pagamento,
				paciente: p,
				dataPedido : data,
				dataRecebimento : data);
		assertTrue compra.validate()
		compra.save()
		
		ItemDeVenda i1 = new ItemDeVenda(lente : lenteValida, quantidadeComprada : 2);
		ItemDeVenda i2 = new ItemDeVenda(lente : lenteValida2, quantidadeComprada : 1);
		
		compra.addToItens(i1);
		compra.addToItens(i2);
		
		compra.save();
		
		assertEquals data, Compra.findByDataRecebimento(data).list().iterator().next().getDataPedido();
		assertEquals data, Compra.findByDataRecebimento(data).list().iterator().next().getDataRecebimento();
		assertEquals 'teste', Compra.findByDataRecebimento(data).list().iterator().next().getPaciente().getNome();
		assertEquals 91f, Compra.findByDataRecebimento(data).list().iterator().next().getValor();
	}
}
