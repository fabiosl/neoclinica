package core

class Fornecimento {
	
	static belongsTo = [f: Fornecedor, l: Lente]
	Date dataPedido
	int quantidade
	float preco
}
