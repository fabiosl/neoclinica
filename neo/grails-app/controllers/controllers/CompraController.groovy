package controllers

import core.Compra 

/**
 * Controladora de compras. Controla as atividades de CRUD sob
 * as compras realizadas ba clinica. Classe gerada pelo framework Grails.
 *
 * @see core.Compra
 */
class CompraController {
	
	def scaffold = Compra;
	
	def index = {
		redirect(action : 'create')
		}
	
//	def save = {
//		def transacaoRealizada = new TransacaoEstoque();
//		transacaoRealizada.dataRealizacao = params.dataPedido;
//		transacaoRealizada.tipoTransacao = TransacaoKind.VENDA;
//		transacaoRealizada.usuario = pegar login do usuario logado;
//		transacaoRealizada.quantidade = params.quantidade;
//		transacaoRealizada.save();
//	}
}
