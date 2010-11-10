package controllers

import core.Medico
import core.ProcedimentoMedico

class AgendaController {
	
	def procedimentos
	def index = {
	}
	
	def escolherMedico = {
		def nomeMedico = params.medico
		redirect(action:'semanal', params : [medico: nomeMedico])
	}
	
	def semanal = {
		def medico = Medico.findByUserRealName(params.medico)
		procedimentos = ProcedimentoMedico.findByMedico(medico)
		return [tudo: procedimentos]
	}
	
	def inicio = {
		redirect(action:'index')
	}
}
