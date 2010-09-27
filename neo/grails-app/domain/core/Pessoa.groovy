package core;

/**
 * Classe de domínio abstrata (sem repositorio de dados) do "core" do sistema.
 * Mantem as informacoes especificadas no modelo de dados do projeto (generalizacao de pacientes e medicos).
 */
public abstract class Pessoa implements Comparable {
	String nome;
	String endereco;
	String telefone;
	Date nascimento;
	Sexo sexo;
	
	static constraints = {
		nome(nullable : false, blank : false, maxSize : 100, minSize : 3)
		endereco(nullable : true, maxSize : 255)
		telefone(nullable : true, blank : true, maxSize : 15)
		sexo(nullable : false)
		nascimento(nullable : false)
	}
	
	public int calculaIdade() {
		Date atual = new Date()
		int idade = atual.getYear() - nascimento.getYear()
		if (atual.getMonth() < nascimento.getMonth() || (atual.getMonth() == nascimento.getMonth() && atual.getDate() < nascimento.getDate())) {
			idade--;
		}
		return idade
	}
	
	public String dataNascimentoDDMMYY() {
		return (nascimento.getDate()) + "/" + (1 + nascimento.getMonth()) + "/" + (1900 + nascimento.getYear());
	}
	
	public int compareTo(obj) {
		nome.compareTo(obj.nome)
	}
	
	public String toString() {
		return getNome() + " (" + dataNascimentoDDMMYY() + ")"
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Pessoa)) {
			return false;
		}
		return o.id == id
	}
}
