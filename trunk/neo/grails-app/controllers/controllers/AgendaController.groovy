package controllers

import core.Medico 
import core.ProcedimentoMedico 

class AgendaController {
	
	def procedimentos
	def index = {
	}
	
	def escolherMedico = {
		def nomeMedico = params.medico
		def medico = Medico.findByUserRealName(nomeMedico)
		procedimentos = ProcedimentoMedico.findByMedico(medico)
		redirect(action:'semanal', params : [procs: procedimentos])
	}
	
	def semanal = {
		return [tudo: params.procs]
	}
	
	def inicio = {
		redirect(action:'index')
	}
}
