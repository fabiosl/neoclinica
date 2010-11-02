package core

/**
 * Classe de dominio pertencente ao "core" do sistema. Mantem as informacoes especificadas no modelo
 * de dados do projeto para representar os itens de venda: a lente associada e a quantidade comprada dessa lente
 */
class ItemDeVenda {
	Lente lente;
	Integer quantidadeComprada = 1;
	
	/**
	 * Restricoes de integridade
	 */
	static constraints = {
		lente(nullable : false)
		quantidadeComprada(nullable : false, min : 1)
	}
	
	/**
	 * Restricao de dependencia entre item de venda e compra.
	 */
	static belongsTo = [compra : Compra]
	
	public Float valorTotal() {
		if (lente == null || quantidadeComprada == null) {
			return 0.0;
		}
		return lente.getValor() * quantidadeComprada
	}
}
