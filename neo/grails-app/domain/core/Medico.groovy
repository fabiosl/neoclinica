package core

import acesso.Usuario 

/**
 * Classe de dominio que mantem informacoes sobre os medicos cadastrados na clinica.
 * Um medico e um tipo especial de usuario, com informacoes extras sobre seus dados trabalhistas.
 */
class Medico extends Usuario {
	String crm
	String especialidade
	
	public String toString() {
		return getUserRealName();
	}
	
	/**
	 * Funcao de ordenacao para medicos
	 * @param outro medico a comparar
	 * @return -1 se este medico for menor, 0 se forem iguais, e 1 se for maior
	 */
	public int compareTo(outro) {
		if (!(outro instanceof Medico)) {
			return 1;
		}
		return getUsername().compareTo(outro.getUsername())
	}
}
