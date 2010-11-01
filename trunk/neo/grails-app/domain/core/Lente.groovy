package core

/**
 * Classe de dominio que mantem informacoes sobre os tipos de lente cadastrados na clinica.
 * Aqui sao armazenados os dados de estoque.
 */
class Lente {
	String tipo;
	Integer quantidade = 0;
	Float valor = 0.0;
	
	/**
	 * Restricoes de integridade
	 */
	static constraints = {
		tipo(nullable : false, blank : false, maxSize : 100, minSize : 3)
		quantidade(nullable : false, min : 0)
		valor(nullable : false, min : 0F)
	}
	
	
	public String toString() {
		return getTipo();
	}
	
	/*public String toString() {
		return "Lente do tipo: " + getTipo() + ". Valor de compra: " + valor + ". Quantidade em estoque: " + quantidade
	}*/
}
