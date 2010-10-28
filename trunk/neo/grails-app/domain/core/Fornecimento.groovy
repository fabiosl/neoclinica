package core

/**
 * Classe de dominio que mantem informacoes sobre os fornecimentos realizados para a clinica.
 */
class Fornecimento {
	Date dataPedido
	int quantidade
	float preco
	
	/**
	 * Relacionamento 1:1 com Fornecedor e Lente.
	 */
	static belongsTo = [f: Fornecedor, l: Lente]
}
