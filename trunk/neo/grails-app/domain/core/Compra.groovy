package core

/**
 * Classe de dominio que mantem informacoes sobre as vendas feitas pela clinica.
 * Uma venda e um tipo de procedimento, acrescentando as datas e os itens vendidos.
 */
class Compra extends Procedimento {
	Date dataPedido
	Date dataRecebimento
	
	/**
	 * Restricoes de integridade
	 */
	static constraints = {
		dataPedido(nullable : false)
	}
}
