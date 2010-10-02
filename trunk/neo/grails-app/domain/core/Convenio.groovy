package core

/**
 * Classe de dominio que mantem informacoes sobre os convenios aceitos pela clinica.
 * A unica informacao requerida a principio eh o nome.
 */
class Convenio implements Comparable<Convenio>{
	String nome;
	
	/**
	 * Restricoes de integridade
	 */
	static constraints = {
		nome(nullable : false, blank : false)
	}
	
	/**
	 * Representacao em string do convenio
	 */
	public String toString(){
		return this.nome;
	}
	
	/**
	 * Funcao de ordenacao para convenios
	 * @param outro convenio a comparar
	 * @return -1 se este convenio for menor, 0 se forem iguais, e 1 se for maior
	 */
	public int compareTo(outro) {
		if (!(outro instanceof Convenio)) {
			return 1;
		}
		return nome.compareTo(outro.nome)
	}
}
