package core

class Fornecedor {
	String cnpj;
	String nome;
	String endereco;
	String telefone;
	
	static hasMany = [lentes : Lente]
	
	static constraints = {
		nome(nullable : false, blank : false, maxSize : 100, minSize : 3)
		endereco(nullable : true, maxSize : 255)
		cnpj(nullable : true, maxSize : 15)
		telefone(nullable : true, blank : true, maxSize : 13)
	}
}
