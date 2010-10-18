package controllers

import acesso.Hierarquia 
import core.Medico 

/**
 * Controladora de medicos. Controla as atividades de CRUD sob
 * os medicos que trabalham no sistema.
 *
 * @see core.Medico
 */
class MedicoController {
	def authenticateService
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	/**
	 * Acao executada ao acessar /medico (por default exibe a lista).
	 */
	def index = {
		redirect(action: "list", params: params)
	}
	
	/**
	 * Acao de listagem de medicos.
	 */
	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[medicoInstanceList: Medico.list(params), medicoInstanceTotal: Medico.count()]
	}
	
	/**
	 * Acao de criacao dos medicos (abertura do formulario).
	 */
	def create = {
		def medicoInstance = new Medico()
		medicoInstance.properties = params
		return [medicoInstance : medicoInstance]
	}
	
	/**
	 * Acao para salvar os medicos apos preenchimento do formulario de criacao.
	 */
	def save = {
		def medicoInstance = new Medico(params)
		medicoInstance.passwd = authenticateService.encodePassword(medicoInstance.passwd)
		
		def roleAdmin = Hierarquia.findByAuthority('ROLE_ADMIN')
		roleAdmin.addToPeople(medicoInstance)
		roleAdmin.save()
		
		if (medicoInstance.save(flush: true)) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'medico.label', default: 'Medico'), medicoInstance.id])}"
			redirect(action: "show", id: medicoInstance.id)
		}
		else {
			render(view: "create", model: [medicoInstance: medicoInstance])
		}
	}
	
	/**
	 * Acao de exibicao do medico, com dados resumidos.
	 */
	def show = {
		def medicoInstance = Medico.get(params.id)
		if (!medicoInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'medico.label', default: 'Medico'), params.id])}"
			redirect(action: "list")
		}
		else {
			[medicoInstance: medicoInstance]
		}
	}
	
	/**
	 * Acao de edicao de medico, abertura do formulario.
	 */
	def edit = {
		def medicoInstance = Medico.get(params.id)
		if (!medicoInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'medico.label', default: 'Medico'), params.id])}"
			redirect(action: "list")
		}
		else {
			return [medicoInstance: medicoInstance]
		}
	}
	
	/**
	 * Acao de edicao do medico, apos preenchimento do formulario.
	 */
	def update = {
		def medicoInstance = Medico.get(params.id)
		
		if (medicoInstance) {
			if (params.version) {
				def version = params.version.toLong()
				if (medicoInstance.version > version) {
					
					medicoInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'medico.label', default: 'Medico')] as Object[], "Another user has updated this Medico while you were editing")
					render(view: "edit", model: [medicoInstance: medicoInstance])
					return
				}
			}
			
			if (!medicoInstance.hasErrors() && medicoInstance.save(flush: true)) {
				flash.message = "${message(code: 'default.updated.message', args: [message(code: 'medico.label', default: 'Medico'), medicoInstance.id])}"
				redirect(action: "show", id: medicoInstance.id)
			}
			else {
				render(view: "edit", model: [medicoInstance: medicoInstance])
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'medico.label', default: 'Medico'), params.id])}"
			redirect(action: "list")
		}
	}
	
	/**
	 * Acao de remocao do medico do sistema.
	 */
	def delete = {
		def medicoInstance = Medico.get(params.id)
		if (medicoInstance) {
			try {
				Hierarquia.findAll().each { it.removeFromPeople(medicoInstance)
				}
				medicoInstance.delete(flush: true)
				flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'medico.label', default: 'Medico'), params.id])}"
				redirect(action: "list")
			}
			catch (org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'medico.label', default: 'Medico'), params.id])}"
				redirect(action: "show", id: params.id)
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'medico.label', default: 'Medico'), params.id])}"
			redirect(action: "list")
		}
	}
}
