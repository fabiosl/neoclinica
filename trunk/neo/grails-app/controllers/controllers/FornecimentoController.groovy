package controllers

import core.Fornecedor;
import core.Fornecimento;
import core.Lente 

/**
 * Controladora de fornecimentos. Controla as atividades de CRUD sob
 * os fornecimentos realizados a clinica. Classe gerada pelo framework Grails.
 *
 * @see core.Fornecimento
 */
class FornecimentoController {
	def scaffold = Fornecimento;
	
	def index = {
		redirect(action : 'create')
	}
	
	def create = {
		def lentes = Lente.findAll()
		def lista = []
		for(Lente l: lentes){
			lista.add(l.getTipo())
		}
		def fornecedores = Fornecedor.findAll()
		def lista2 = []
		for(Fornecedor f: fornecedores){
			lista2.add(f.getNome())
		}
		return [validos : lista, validos2: lista2]
	}
	
	def edit = {
		//		def transacaoRealizada = new TransacaoEstoque();
		//		transacaoRealizada.dataRealizacao = params.dataPedido;
		//		transacaoRealizada.tipoTransacao = TransacaoKind.RECEBIMENTO;
		//		transacaoRealizada.usuario = pegar login do usuario logado;
		//		transacaoRealizada.quantidade = FornecimentoAtual.quantidade;
		//		transacaoRealizada.save();
		}
	
	def save = {
		//		def transacaoRealizada = new TransacaoEstoque();
		//		transacaoRealizada.dataRealizacao = params.dataPedido;
		//		transacaoRealizada.tipoTransacao = TransacaoKind.FORNECIMENTO;
		//		transacaoRealizada.usuario = pegar login do usuario logado;
		//		transacaoRealizada.quantidade = params.quantidade;
		//		transacaoRealizada.save();
		System.out.print("CHAMOU!! com ");
		System.out.println(params.f);
		redirect(action : 'create')
	}
}
