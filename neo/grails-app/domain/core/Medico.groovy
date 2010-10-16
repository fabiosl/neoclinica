package core

import acesso.Usuario 

/**
 * Classe de dominio que mantem informacoes sobre os medicos cadastrados na clinica.
 * Um medico e um tipo especial de usuario, com informacoes extras sobre seus dados trabalhistas.
 */
class Medico extends Usuario {
	String crm
	String especialidade
}
