package core

/**
 * Classe de dominio que mantem informacoes sobre os fornecedores cadastrados na clinica.
 */
class Fornecedor {
	String cnpj;
	String nome;
	String endereco;
	String telefone;
	
	/**
	 * Relacao n por n das das lentes fornecidas por este fornecedor
	 */
	static hasMany = [lentes : Lente]
	
	/**
	 * Restricoes de integridade
	 */
	static constraints = {
		nome(nullable : false, blank : false, maxSize : 100, minSize : 3)
		endereco(nullable : true, maxSize : 255)
		cnpj(nullable : true, maxSize : 15)
		telefone(nullable : true, blank : true, maxSize : 13)
	}
}
