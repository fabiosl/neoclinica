package controllers

import core.Fornecimento 

/**
 * Controladora de fornecimentos. Controla as atividades de CRUD sob
 * os fornecimentos realizados a clinica. Classe gerada pelo framework Grails.
 *
 * @see core.Fornecimento
 */
class FornecimentoController {
	def transacoesService
	
	def index = {
		redirect(action: "list", params: params)
	}
	
	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[fornecimentoInstanceList: Fornecimento.list(params), fornecimentoInstanceTotal: Fornecimento.count()]
	}
	
	def create = {
		def fornecimentoInstance = new Fornecimento()
		fornecimentoInstance.properties = params
		return [fornecimentoInstance: fornecimentoInstance]
	}
	
	def save = {
		def fornecimentoInstance = new Fornecimento(params)
		if (fornecimentoInstance.save(flush: true)) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'fornecimento.label', default: 'Fornecimento'), fornecimentoInstance.id])}"
			redirect(action: "show", id: fornecimentoInstance.id)
		}
		else {
			render(view: "create", model: [fornecimentoInstance: fornecimentoInstance])
		}
	}
	
	def show = {
		def fornecimentoInstance = Fornecimento.get(params.id)
		if (!fornecimentoInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fornecimento.label', default: 'Fornecimento'), params.id])}"
			redirect(action: "list")
		}
		else {
			[fornecimentoInstance: fornecimentoInstance]
		}
	}
	
	def edit = {
		def fornecimentoInstance = Fornecimento.get(params.id)
		if (!fornecimentoInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fornecimento.label', default: 'Fornecimento'), params.id])}"
			redirect(action: "list")
		} else if (fornecimentoInstance.getDataRecebimento() != null) {
			flash.message = "Esse fornecimento ja foi confirmado, impossivel editar!"
			redirect(action: "show", id: fornecimentoInstance.id)
		} else { 
			return [fornecimentoInstance: fornecimentoInstance]
		}
	}
	
	def update = {
		def fornecimentoInstance = Fornecimento.get(params.id)
		if (fornecimentoInstance) {
			if (params.version) {
				def version = params.version.toLong()
				if (fornecimentoInstance.version > version) {
					
					fornecimentoInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'fornecimento.label', default: 'Fornecimento')] as Object[], "Another user has updated this Fornecimento while you were editing")
					render(view: "edit", model: [fornecimentoInstance: fornecimentoInstance])
					return
				}
			}
			fornecimentoInstance.properties = params
			if (!fornecimentoInstance.hasErrors() && fornecimentoInstance.save(flush: true)) {
				flash.message = "${message(code: 'default.updated.message', args: [message(code: 'fornecimento.label', default: 'Fornecimento'), fornecimentoInstance.id])}"
				redirect(action: "show", id: fornecimentoInstance.id)
			}
			else {
				render(view: "edit", model: [fornecimentoInstance: fornecimentoInstance])
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fornecimento.label', default: 'Fornecimento'), params.id])}"
			redirect(action: "list")
		}
	}
	
	def delete = {
		def fornecimentoInstance = Fornecimento.get(params.id)
		if (fornecimentoInstance) {
			try {
				fornecimentoInstance.delete(flush: true)
				flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'fornecimento.label', default: 'Fornecimento'), params.id])}"
				redirect(action: "list")
			}
			catch (org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'fornecimento.label', default: 'Fornecimento'), params.id])}"
				redirect(action: "show", id: params.id)
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fornecimento.label', default: 'Fornecimento'), params.id])}"
			redirect(action: "list")
		}
	}
	
	def confirmarEntregaFornecimento = {
		def fornecimentoInstance = Fornecimento.get(params.id)
		if (fornecimentoInstance) {
			try {
				transacoesService.confirmarFornecimento(fornecimentoInstance)
				flash.message = "Fornecimento confirmado, estoque atualizado!"
				redirect(action: "show", id : fornecimentoInstance.id)
			} catch (Exception e) {
				flash.message = e.getMessage()
				redirect(action: "show", id : fornecimentoInstance.id)
			}
		} else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fornecimento.label', default: 'Fornecimento'), params.id])}"
			redirect(action: "list")
		}
	}
}
