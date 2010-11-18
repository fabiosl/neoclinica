import groovy.util.GroovyTestCase;
import core.Lente;
import core.Fornecedor;
import core.Fornecimento;
import core.TransacaoEstoque

/**
 * Testes de aceitacao da user story 11 (Geracao de Relatorio de Estoque)
 */
class RelatoriosEstoqueAcceptanceTests extends GroovyTestCase {
	/**
	 * Teste de Aceitação 11.1: Emitir relatório do estoque disponível de lentes (Operação Realizada com Sucesso se logado como Administrador). 
	 */
	void test11_1(){
		Lente.list()*.delete();
		Fornecedor.list()*.delete();
		Fornecimento.list()*.delete();
		assertEquals (Lente.list().size(),0)
		def lenteValida = new Lente(
				tipo : 'Look',
				quantidade : 15,
				valor : 0f);
		assertTrue lenteValida.validate()
		lenteValida.save()
		
		assertTrue Lente.list().size() != 0
	}
	
	/**
	 * Teste de Aceitação 11.2: Emitir relatório da atividade do estoque de lentes (Operação Realizada com Sucesso se logado como Administrador). 
	 */
	void test11_2(){
		Lente.list()*.delete();
		Fornecedor.list()*.delete();
		Fornecimento.list()*.delete();
		
		def lenteValida = new Lente(
				tipo : 'Look',
				quantidade : 15,
				valor : 0f);
		assertTrue lenteValida.validate()
		lenteValida.save()
		
		def fornecedorValido = new Fornecedor(
				cnpj : '1234567890',
				nome : 'OticaACT',
				endereco : 'Rua Maciel Pinheiro 255, Centro',
				telefone : '34411312');
		assertTrue fornecedorValido.validate()
		fornecedorValido.save()
		assertNotNull Fornecedor.findByNome('OticaACT')
		def fornecimentoValido = new Fornecimento(
				dataPedido : new Date(),
				dataRecebimento : new Date(),
				quantidade : 10,
				preco : 100,
				lente : lenteValida,
				fornecedor : fornecedorValido);
		assertTrue fornecimentoValido.validate()
		fornecimentoValido.save()
		def transacoes = TransacaoEstoque.findAllByDataRealizacaoBetween(new Date(), new Date());
		assertNotNull transacoes
	}
}
