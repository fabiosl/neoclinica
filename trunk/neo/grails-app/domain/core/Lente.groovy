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
	
	public boolean equals(outraLente) {
		if (!(outraLente instanceof Lente)) {
			return false
		}
		return this.id == outraLente.id
	}
	
	public String descricao() {
		return getTipo() + " / Quantidade em estoque: (" + getQuantidade() + ")";
	}
	
	public String toString() {
		return getTipo();
	}
}
