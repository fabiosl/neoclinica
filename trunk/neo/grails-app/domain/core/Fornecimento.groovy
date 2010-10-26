package core

class Fornecimento {
	
	static belongsTo = [f: Fornecedor, l: Lente]
	Date dataEntrega
	int quantidade
	float preco
}
