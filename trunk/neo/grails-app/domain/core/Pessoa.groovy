package core;

import java.util.Date;

/**
 * Classe de dominio abstrata (sem repositorio de dados) do "core" do sistema.
 * Mantem as informacoes especificadas no modelo de dados do projeto (generalizacao de pacientes e medicos).
 */
public abstract class Pessoa implements Comparable {
	String nome;
	String endereco;
	String telefone;
	Date nascimento;
	Sexo sexo;
	
	/**
	 * Restricoes de integridade
	 */
	static constraints = {
		nome(nullable : false, blank : false, maxSize : 100, minSize : 3)
		endereco(nullable : true, maxSize : 255)
		telefone(nullable : true, blank : true, maxSize : 15)
		sexo(nullable : false)
		nascimento(nullable : false, validator: {val ->
			if (val.after(new Date())) {
				return 'dataNascimentoInvalida'
			}
		})
	}
	
	/**
	 * Calcula a idade da pessoa baseada na hora atual
	 * @return a idade da pessoa
	 */
	public int calculaIdade() {
		Date atual = new Date()
		int idade = atual.getYear() - nascimento.getYear()
		if (atual.getMonth() < nascimento.getMonth() || (atual.getMonth() == nascimento.getMonth() && atual.getDate() < nascimento.getDate())) {
			idade--;
		}
		return idade
	}
	
	/**
	 * Retorna a data de nascimento formatada no padrao DD/MM/YYYY
	 * @return a data de nascimento formatada
	 */
	public String dataNascimentoDDMMYY() {
		def dia = DateParser.addZeros(nascimento.getDate(), 2);
		def mes = DateParser.addZeros(nascimento.getMonth(), 2)
		return dia + "/" +mes+ "/" + (1900 + nascimento.getYear());
	}
	
	/**
	 * Funcao de ordenacao para pessoas
	 * @param obj pessoa a comparar
	 * @return -1 se este convenio for menor, 0 se forem iguais, e 1 se for maior
	 */
	public int compareTo(obj) {
		return nome.compareTo(obj.nome)
	}
	
	/**
	 * Representacao string da pessoa
	 */
	public String toString() {
		return getNome() + " (" + dataNascimentoDDMMYY() + ")"
	}
	
	/**
	 * Diz se duas pessoas sao iguais
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Pessoa)) {
			return false;
		}
		return o.id == id
	}
}
