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
//	
//	def save = {
//		def compraRealizada = new Compra(params);
//		def transacaoRealizada = new TransacaoEstoque();
//		transacaoRealizada.dataRealizacao = compraRealizada.dataPedido;
//		transacaoRealizada.tipoTransacao = TransacaoKind.VENDA;
//		transacaoRealizada.valor = compraRealizada.valor;
//		System.out.println("Salvando " + transacaoRealizada);
//		transacaoRealizada.save();
//		compraRealizada.save(); 
//		render(view: "create", model: [compraInstance: compraRealizada])
//	}
}
