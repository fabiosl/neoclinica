package core

/**
 * Classe de dominio que mantem informacoes sobre os fornecimentos realizados para a clinica.
 */
class Fornecimento {
	Date dataPedido
	Date dataRecebimento
	Integer quantidade = 0
	Float preco = 0.0
	
	/**
	 * Relacionamento 1:1 com Fornecedor e Lente.
	 */
	static belongsTo = [fornecedor : Fornecedor, lente : Lente]
	
	/**
	 * Restricoes de integridade
	 */
	static constraints = {
		dataPedido(nullable : false)
		dataRecebimento(nullable : true)
		quantidade(nullable : false, min : 0)
		preco(nullable : false, min : 0F)
	}
	
	public String statusDeEntrega() {
		return dataRecebimento != null ? "Entregue" : "Pendente";
	}
}
