package core

/**
 * Classe de dominio que mantem informacoes sobre os tipos de lente cadastrados na clinica.
 * Aqui sao armazenados os dados de estoque.
 */
class Lente {
	String tipo;
	int quantidade;
	float valor;
	
	/**
	 * Restricoes de integridade
	 */
	static constraints = {
		tipo(nullable : false, blank : false, maxSize : 100, minSize : 3)
		quantidade(nullable : false, min : 0)
		valor(nullable : false, min : 0F)
	}
	
	public String toString() {
		return "Lente do tipo: " + getTipo() + ". Valor de compra: " + valor
	}
}
