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
		dataRecebimento(nullable : true)
	}
	
	/**
	 * Relacao um para muitos entre compra e itens de venda
	 */
	static hasMany = [itens : ItemDeVenda]
	
	public Float getValor() {
		Float valor = 0.0;
		for (ItemDeVenda item : itens) {
			valor += item.valorTotal()
		}
		return valor
	}
	
	public String statusDeEntrega() {
		return dataRecebimento != null ? "Entregue" : "Pendente";
	}
}
