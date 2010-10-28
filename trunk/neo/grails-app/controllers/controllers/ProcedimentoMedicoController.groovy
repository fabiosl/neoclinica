package controllers

import core.Paciente 
import core.ProcedimentoMedico 

/**
 * Controladora de procedimentos medicos. Controla as atividades de CRUD sob
 * os procedimentos medicos da clinica. Classe gerada pelo framework Grails.
 *
 * @see core.ProcedimentoMedico
 */
class ProcedimentoMedicoController {
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def index = {
	}
	
	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		def paciente = Paciente.get(params.idPaciente)
		def consulta = ProcedimentoMedico.createCriteria().list(params) {
			eq("paciente", paciente)
		}
		def cont = consulta != null ? consulta.count() : 0
		[procedimentoMedicoInstanceList: consulta, procedimentoMedicoInstanceTotal: cont, paciente : paciente]
	}
	
	def create = {
		def procedimentoMedicoInstance = new ProcedimentoMedico()
		procedimentoMedicoInstance.properties = params
		def paciente = null
		if (params.idPaciente != null) {
			paciente = Paciente.get(params.idPaciente)
		}
		return [procedimentoMedicoInstance : procedimentoMedicoInstance, pacientePreDefinido : paciente]
	}
	
	def save = {
		def procedimentoMedicoInstance = new ProcedimentoMedico(params)
		if (procedimentoMedicoInstance.save(flush: true)) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), procedimentoMedicoInstance.id])}"
			redirect(action: "show", id: procedimentoMedicoInstance.id)
		}
		else {
			render(view: "create", model: [procedimentoMedicoInstance: procedimentoMedicoInstance])
		}
	}
	
	def show = {
		def procedimentoMedicoInstance = ProcedimentoMedico.get(params.id)
		if (!procedimentoMedicoInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), params.id])}"
			redirect(action: "index")
		}
		else {
			[procedimentoMedicoInstance: procedimentoMedicoInstance]
		}
	}
	
	def edit = {
		def procedimentoMedicoInstance = ProcedimentoMedico.get(params.id)
		if (!procedimentoMedicoInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), params.id])}"
			redirect(action: "list", params : [idPaciente : procedimentoMedicoInstance.paciente.id])
		}
		else {
			return [procedimentoMedicoInstance: procedimentoMedicoInstance]
		}
	}
	
	def update = {
		def procedimentoMedicoInstance = ProcedimentoMedico.get(params.id)
		if (procedimentoMedicoInstance) {
			if (params.version) {
				def version = params.version.toLong()
				if (procedimentoMedicoInstance.version > version) {
					
					procedimentoMedicoInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico')] as Object[], "Another user has updated this ProcedimentoMedico while you were editing")
					render(view: "edit", model: [procedimentoMedicoInstance: procedimentoMedicoInstance])
					return
				}
			}
			procedimentoMedicoInstance.properties = params
			if (!procedimentoMedicoInstance.hasErrors() && procedimentoMedicoInstance.save(flush: true)) {
				flash.message = "${message(code: 'default.updated.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), procedimentoMedicoInstance.id])}"
				redirect(action: "show", id: procedimentoMedicoInstance.id)
			}
			else {
				render(view: "edit", model: [procedimentoMedicoInstance: procedimentoMedicoInstance])
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), params.id])}"
			redirect(action: "list", params : [idPaciente : procedimentoMedicoInstance.paciente.id])
		}
	}
	
	def delete = {
		def procedimentoMedicoInstance = ProcedimentoMedico.get(params.id)
		if (procedimentoMedicoInstance) {
			try {
				procedimentoMedicoInstance.delete(flush: true)
				flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), params.id])}"
				redirect(action: "list", params : [idPaciente : procedimentoMedicoInstance.paciente.id])
			}
			catch (org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), params.id])}"
				redirect(action: "show", id: params.id)
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'procedimentoMedico.label', default: 'ProcedimentoMedico'), params.id])}"
			redirect(action: "list", params : [idPaciente : procedimentoMedicoInstance.paciente.id])
		}
	}
}
