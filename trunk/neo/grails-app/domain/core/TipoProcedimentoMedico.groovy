package core;

/**
 * Classe de dominio que mantem informacoes sobre os tipos de procedimentos cadastraveis na clinica.
 * Feita para manter mais flexivel o cadastro de um novo tipo de procedimento medico.
 */
class TipoProcedimentoMedico {
	String nome;
	Float valorBase = 0.0;
	
	/**
	 * Restricoes de integridade
	 */
	static constraints = {
		nome(nullable : false, blank : false)
		valorBase(nullable : false, min : 0F)
	}
	
	public String toString() {
		return getNome();
	}
	
	/**
	 * Funcao de ordenacao para tipos de procedimento
	 * @param outro tipo a comparar
	 * @return -1 se este tipo for menor, 0 se forem iguais, e 1 se for maior
	 */
	public int compareTo(outro) {
		if (!(outro instanceof TipoProcedimentoMedico)) {
			return 1;
		}
		return nome.compareTo(outro.nome)
	}
}
