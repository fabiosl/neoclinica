package controllers

import core.Paciente 

/**
 * Controladora de pacientes. Controla as atividades de CRUD sob
 * os pacientes do sistema. Classe gerada pelo framework Grails.
 *
 * @see core.Paciente
 */
class PacienteController {
	def scaffold = Paciente;
	
	def index = {
	}
	
	def list = {
		def nome = params.nome
		if (nome != null) {
			def criterioBusca = "%" + nome + "%"
			def pacientes = Paciente.createCriteria().list(params) {
				like("nome", criterioBusca)
			}
			return [pacienteInstanceList : pacientes, nomeBuscado : nome]
		}
	}
	
	def search = {
		def nome = params.nome
		def criterioBusca = "%" + nome + "%"
		def pacientes = Paciente.createCriteria().list(params) {
			like("nome", criterioBusca)
		}
		render (template : "/common/listaPacientes", model : [nomeBuscado : nome, pacienteInstanceList : pacientes]);
	}
}
