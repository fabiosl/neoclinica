package core

/**
 * Classe de dominio que mantem informacoes sobre os fornecimentos realizados para a clinica.
 */
class Fornecimento {
	Date dataPedido
	Integer quantidade = 0
	Float preco = 0.0
	
	/**
	 * Relacionamento 1:1 com Fornecedor e Lente.
	 */
	static belongsTo = [f: Fornecedor, l: Lente]
	
	/**
	 * Restricoes de integridade
	 */
	static constraints = {
		quantidade(nullable : false, min : 0)
		preco(nullable : false, min : 0F)
	}
}
